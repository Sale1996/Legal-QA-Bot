import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { OntologyEntity } from 'src/app/model/OntologyEntity.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FindEntityModalComponent } from './find-entity-modal/find-entity-modal.component';
import { OntologyEntityService } from 'src/app/services/ontologyEntity.service';
import { FindEntity } from 'src/app/model/FindEntity.model';

@Component({
  selector: 'app-code-book',
  templateUrl: './code-book.component.html',
  styleUrls: ['./code-book.component.css']
})
export class CodeBookComponent implements OnInit {

  chooseEntityForm: FormGroup;
  entities$: Observable<OntologyEntity[]>;
  entities2: OntologyEntity[];
  selectedEntity : OntologyEntity;

  constructor(private formBuilder: FormBuilder, private modalService: NgbModal, private entityService : OntologyEntityService) { }

  ngOnInit() {

    this.getEntities();

    this.chooseEntityForm = this.formBuilder.group({
      entity: this.formBuilder.group({
        entityId: [''],
        entityName: [''],
        entitySparqlQuery: ['']
      }),
    });
  }

  getEntities() {
    this.entities$ = this.entityService.getEntities();
  }


  onSubmit(){
    
  }

  selectEntity(entityId : number){
    this.entityService.getEntityById(entityId).subscribe((data: OntologyEntity) => {
      
      this.selectedEntity = data;
      this.openQueryModal(data);
    
    } );
  }

  openQueryModal(entity : OntologyEntity) {
    const newQueryModal = this.modalService.open(FindEntityModalComponent,
      {
        size: 'lg',
        centered: true,
        backdropClass: 'custom-modal-backdrop'
      });
    newQueryModal.componentInstance.entity = entity;
    newQueryModal.componentInstance.findEntity2.subscribe((findEntity : FindEntity) =>{
          console.log(findEntity);
    });
  }


}
