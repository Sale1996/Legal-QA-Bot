import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { OntologyEntity } from 'src/app/model/OntologyEntity.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FindEntityModalComponent } from './find-entity-modal/find-entity-modal.component';

@Component({
  selector: 'app-code-book',
  templateUrl: './code-book.component.html',
  styleUrls: ['./code-book.component.css']
})
export class CodeBookComponent implements OnInit {

  chooseEntityForm: FormGroup;
  entities$: Observable<OntologyEntity[]>;
  entities2: OntologyEntity[];

  constructor(private formBuilder: FormBuilder, private modalService: NgbModal) { }

  ngOnInit() {

    this.entities2 = [{entityId: 1, entityName: "Kazna", entitySparqlQuery:"Query"}, {entityId: 1, entityName: "Stav", entitySparqlQuery:"QueryStav"},{entityId: 1, entityName: "Clan", entitySparqlQuery:"QueryClan"}];

    this.chooseEntityForm = this.formBuilder.group({
      entity: this.formBuilder.group({
        entityId: [''],
        entityName: [''],
        entitySparqlQuery: ['']
      }),
    });
  }

  onSubmit(){
    
  }

  openQueryModal(entity) {
    const newPriceModal = this.modalService.open(FindEntityModalComponent,
      {
        size: 'lg',
        centered: true,
        backdropClass: 'custom-modal-backdrop'
      });
    newPriceModal.componentInstance.entity = entity;
    newPriceModal.componentInstance.price.subscribe();
  }


}
