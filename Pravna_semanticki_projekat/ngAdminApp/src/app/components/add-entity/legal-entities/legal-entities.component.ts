import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { LegalEntity } from 'src/app/model/LegalEntity.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { LegalEntityService } from 'src/app/services/legalEntity.service';
import { ConfirmationModalComponent } from 'src/app/_shared/confirmation-modal/confirmation-modal.component';
import { LegalEntitiesModelComponent } from './legal-entities-model/legal-entities-model.component';

@Component({
  selector: 'app-legal-entities',
  templateUrl: './legal-entities.component.html',
  styleUrls: ['./legal-entities.component.css']
})
export class LegalEntitiesComponent implements OnInit {


  entities$: Observable<LegalEntity[]>;

  constructor(private modalService: NgbModal, private entityService : LegalEntityService) { }

  ngOnInit() {
    this.getEntities();
  }

  getEntities() {
    this.entities$ = this.entityService.getEntities();
  }

  deleteEntity(entity: LegalEntity) {
    const deleteModalRef = this.modalService.open(ConfirmationModalComponent,
      {
        centered: true,
        backdropClass: 'custom-modal-backdrop'
      });
    deleteModalRef.componentInstance.title = 'Delete Entity';
    deleteModalRef.componentInstance.message = 'Are you sure you want to delete ' + entity.legalEntityName + '?';
    deleteModalRef.componentInstance.answer.subscribe(
      (answer: boolean) => {
        if (answer) {
          this.entityService.deleteEntity(entity.legalEntityId).subscribe(
            () => {
              this.getEntities();
            }
          );
        }
      }
    );
  }

  openEntityModal(id?: number) {
    const agentModalRef = this.modalService.open(LegalEntitiesModelComponent,
      {
        centered: true,
        backdropClass: 'custom-modal-backdrop'
      });

    if (id) {
      agentModalRef.componentInstance.id = id;
    }
    agentModalRef.componentInstance.entity.subscribe(
      (entity: LegalEntity) => {
          if (entity.legalEntityId) {
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
