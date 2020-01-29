import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { OntologyEntity } from 'src/app/model/OntologyEntity.model';
import { FindEntity } from 'src/app/model/FindEntity.model';
import { OntologyEntityService } from 'src/app/services/ontologyEntity.service';
import { FindEntityParameter } from 'src/app/model/FindEntityParameter.model';
import { FindEntitySecondModalComponent } from '../find-entity-second-modal/find-entity-second-modal.component';

@Component({
  selector: 'app-find-entity-modal',
  templateUrl: './find-entity-modal.component.html',
  styleUrls: ['./find-entity-modal.component.css']
})
export class FindEntityModalComponent implements OnInit {

  @Input() creation?: boolean;
  @Input() entity: OntologyEntity;
  @Output() findEntity2: EventEmitter<any> = new EventEmitter();
  entityParameters : FindEntity;

  findEntityForm: FormGroup;
  //prices$: Observable<Price[]>;

  constructor(public activeModal: NgbActiveModal, private modalService: NgbModal, private formBuilder: FormBuilder, private entityService : OntologyEntityService) { }

  ngOnInit() {
    this.getAllParametersOfEntity();

  }

  getAllParametersOfEntity(){
    this.entityService.getParametersOfEntity(this.entity).subscribe((findEntity: FindEntity) => {
      this.entityParameters = findEntity;
      this.formateInputForm();
    });
  }

  formateInputForm(){
    this.findEntityForm = this.formBuilder.group({
      parameters: this.formBuilder.array(this.entityParameters.parameters.map(parameter => this.createMemberGroup(parameter)))

    });
  }

  createMemberGroup(findParameter : FindEntityParameter){
    return this.formBuilder.group({
      ...findParameter,
      ...{ 
        parameter: {
          parameterId: [findParameter.parameter.parameterId],
          parameterName: [findParameter.parameter.parameterName, Validators.required],
          parameterSparqlQuery: [findParameter.parameter.parameterSparqlQuery, Validators.required],
          parameterType: [findParameter.parameter.parameterType, Validators.required],
          isMultiConnection: [findParameter.parameter.isMultiConnection],
          entity: [findParameter.parameter.entity],
          connectedEntity: [findParameter.parameter.connectedEntity]
        },
        wantToFind: [findParameter.wantToFind],
        findParameter: [findParameter.findParameter],
        findEntity: [findParameter.findEntity],
      }
    });
  }



  openSecondQueryModal() {
    const newSecondQueryModal = this.modalService.open(FindEntitySecondModalComponent,
      {
        size: 'lg',
        centered: true,
        backdropClass: 'custom-modal-backdrop'
      });
    newSecondQueryModal.componentInstance.entityParameters = this.findEntityForm.value as FindEntity;
    newSecondQueryModal.componentInstance.findEntity.subscribe(
      (findEntity: FindEntity) => {
              this.findEntity2.emit(findEntity);
              this.closeModal();
      }
    );
  }


  onSubmit() {
    if (this.findEntityForm.valid) {
      this.openSecondQueryModal();
    }
  }

  closeModal() {
    this.activeModal.close();
  }



}