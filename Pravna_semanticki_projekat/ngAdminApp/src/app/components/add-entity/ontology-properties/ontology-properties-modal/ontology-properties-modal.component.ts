import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs';
import { OntologyEntity } from 'src/app/model/OntologyEntity.model';
import { OntologyEntityService } from 'src/app/services/ontologyEntity.service';
import { OntologyParameterService } from 'src/app/services/ontologyParameter.service';
import { OntologyParameter } from 'src/app/model/OntologyParameter.model';

@Component({
  selector: 'app-ontology-properties-modal',
  templateUrl: './ontology-properties-modal.component.html',
  styleUrls: ['./ontology-properties-modal.component.css']
})
export class OntologyPropertiesModalComponent implements OnInit {


  @Input() id?: number;
  @Output() parameter: EventEmitter<any> = new EventEmitter();
  submitBtnText: string;
  parameterForm: FormGroup;
  entities$: Observable<OntologyEntity[]>;
  selectedEntity : OntologyEntity;
  selectedConnectionEntity: OntologyEntity;
  selectedParameterType: string;


  constructor(public activeModal: NgbActiveModal, private formBuilder: FormBuilder, private entityService : OntologyEntityService, private parameterService : OntologyParameterService) {}

  ngOnInit() {

    this.getEntities();

    this.parameterForm = this.formBuilder.group({
      parameterId: [''],
      parameterName: ['', Validators.required],
      parameterSparqlQuery: ['', Validators.required],
      parameterType: ['', Validators.required],
      isMultiConnection: [''],
      entityId: [''],
      connectedEntityId: [''],
      entity: [],
      connectedEntity: []
    });

    if (this.id) {
      this.submitBtnText = 'Save Changes';
      this.getParameterById(this.id);
    } else {
      this.submitBtnText = 'Add Parameter';
    }
  }

  getEntities() {
    this.entities$ = this.entityService.getEntities();
  }

  getParameterById(id: number) {
    
    this.parameterService.getParameterById(id).subscribe(
      (parameter: OntologyParameter) => {
        this.parameterForm.patchValue(parameter);
        this.selectEntity(parameter.entity.entityId);
      }
    );
    
  }

  selectEntity(entityId : number){
    this.entityService.getEntityById(entityId).subscribe((data: OntologyEntity) => this.selectedEntity = data );
  }

  selectConnectedEntity(entityId : number){
    this.entityService.getEntityById(entityId).subscribe((data: OntologyEntity) => this.selectedConnectionEntity = data );
  }

  chooseParameterType(parameterType: string){
    this.selectedParameterType = parameterType;
  }

  onSubmit() {
    
    if (this.parameterForm.valid) {
      var return_value = this.parameterForm.value as OntologyParameter;
      return_value.entity = this.selectedEntity;
      return_value.connectedEntity = this.selectedConnectionEntity;
      this.parameter.emit(return_value);
      this.activeModal.close();
    }
    
  }

}
