import { Component, OnInit } from '@angular/core';
import { OntologyParameter } from 'src/app/model/OntologyParameter.model';
import { Observable } from 'rxjs';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { OntologyEntity } from 'src/app/model/OntologyEntity.model';
import { ConfirmationModalComponent } from 'src/app/_shared/confirmation-modal/confirmation-modal.component';
import { OntologyTypesModalComponent } from '../ontology-types/ontology-types-modal/ontology-types-modal.component';
import { OntologyPropertiesModalComponent } from './ontology-properties-modal/ontology-properties-modal.component';
import { OntologyParameterService } from 'src/app/services/ontologyParameter.service';

@Component({
  selector: 'app-ontology-properties',
  templateUrl: './ontology-properties.component.html',
  styleUrls: ['./ontology-properties.component.css']
})
export class OntologyPropertiesComponent implements OnInit {

 
  parameters$: Observable<OntologyParameter[]>;

  constructor(private modalService: NgbModal, private parameterService: OntologyParameterService) { }

  ngOnInit() {
    this.getParameters();
  }

  getParameters() {
    this.parameters$ = this.parameterService.getParameters();
  }


  deleteParameter(parameter: OntologyParameter) {
    const deleteModalRef = this.modalService.open(ConfirmationModalComponent,
      {
        centered: true,
        backdropClass: 'custom-modal-backdrop'
      });
    deleteModalRef.componentInstance.title = 'Delete Parameter';
    deleteModalRef.componentInstance.message = 'Are you sure you want to delete ' + parameter.parameterName + '?';
    deleteModalRef.componentInstance.answer.subscribe(
      (answer: boolean) => {
        if (answer) {
          this.parameterService.deleteParameter(parameter.parameterId).subscribe(
            () => {
              this.getParameters();
            }
          );
        }
      }
    );
  }

  openParameterModal(id?: number) {
    const agentModalRef = this.modalService.open(OntologyPropertiesModalComponent,
      {
        centered: true,
        backdropClass: 'custom-modal-backdrop'
      });

    if (id) {
      agentModalRef.componentInstance.id = id;
    }
    agentModalRef.componentInstance.parameter.subscribe(
      (parameter: OntologyParameter) => {
          if (parameter.parameterId) {
            this.parameterService.updateParameter(parameter).subscribe(
              () => {
                this.getParameters();
              }
            );
            
          } else {
              
            this.parameterService.createParameter(parameter).subscribe(
                () => {
                  this.getParameters();
                }
              );
          }
      }
    );
  }
}
