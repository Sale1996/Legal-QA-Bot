import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { OntologyEntity } from 'src/app/model/OntologyEntity.model';
import { FindEntity } from 'src/app/model/FindEntity.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { OntologyEntityService } from 'src/app/services/ontologyEntity.service';
import { FindEntityParameter } from 'src/app/model/FindEntityParameter.model';

@Component({
  selector: 'app-find-entity-second-modal',
  templateUrl: './find-entity-second-modal.component.html',
  styleUrls: ['./find-entity-second-modal.component.css']
})
export class FindEntitySecondModalComponent implements OnInit {

  @Output() price: EventEmitter<any> = new EventEmitter();
  @Input() entityParameters : FindEntity;

  findEntityForm: FormGroup;

  constructor(public activeModal: NgbActiveModal, private formBuilder: FormBuilder, private entityService : OntologyEntityService) { }


  ngOnInit() {

    this.formateInputForm();

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

  onSubmit() {
    if (this.findEntityForm.valid) {


    }
  }

  closeModal() {
    this.activeModal.close();
   
  }


}
