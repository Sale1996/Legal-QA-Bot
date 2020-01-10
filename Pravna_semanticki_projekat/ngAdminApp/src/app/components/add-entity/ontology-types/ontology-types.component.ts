import { Component, OnInit } from '@angular/core';
import { OntologyEntity } from 'src/app/model/OntologyEntity.model';
import { Observable } from 'rxjs';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ConfirmationModalComponent } from 'src/app/_shared/confirmation-modal/confirmation-modal.component';
import { OntologyTypesModalComponent } from './ontology-types-modal/ontology-types-modal.component';
import { OntologyEntityService } from 'src/app/services/ontologyEntity.service';

@Component({
  selector: 'app-ontology-types',
  templateUrl: './ontology-types.component.html',
  styleUrls: ['./ontology-types.component.css']
})
export class OntologyTypesComponent implements OnInit {


  entities$: Observable<OntologyEntity[]>;

  constructor(private modalService: NgbModal, private entityService : OntologyEntityService) { }

  ngOnInit() {
    this.getEntities();
  }

  getEntities() {
    this.entities$ = this.entityService.getEntities();
  }

  deleteEntity(entity: OntologyEntity) {
    const deleteModalRef = this.modalService.open(ConfirmationModalComponent,
      {
        centered: true,
        backdropClass: 'custom-modal-backdrop'
      });
    deleteModalRef.componentInstance.title = 'Delete Entity';
    deleteModalRef.componentInstance.message = 'Are you sure you want to delete ' + entity.entityName + '?';
    deleteModalRef.componentInstance.answer.subscribe(
      (answer: boolean) => {
        if (answer) {
          this.entityService.deleteEntity(entity.entityId).subscribe(
            () => {
              this.getEntities();
            }
          );
        }
      }
    );
  }

  openEntityModal(id?: number) {
    const agentModalRef = this.modalService.open(OntologyTypesModalComponent,
      {
        centered: true,
        backdropClass: 'custom-modal-backdrop'
      });

    if (id) {
      agentModalRef.componentInstance.id = id;
    }
    agentModalRef.componentInstance.entity.subscribe(
      (entity: OntologyEntity) => {
          if (entity.entityId) {
            this.entityService.updateEntity(entity).subscribe(
              () => {
                this.getEntities();
              }
            );
          } else {  
            this.entityService.createEntity(entity).subscribe(
                () => {
                  this.getEntities();
                }
              );
              
          }
      }
    );
  }
}