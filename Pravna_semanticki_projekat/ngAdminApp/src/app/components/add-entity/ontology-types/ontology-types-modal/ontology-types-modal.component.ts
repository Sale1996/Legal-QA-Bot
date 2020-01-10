import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { OntologyEntityService } from 'src/app/services/ontologyEntity.service';
import { OntologyEntity } from 'src/app/model/OntologyEntity.model';

@Component({
  selector: 'app-ontology-types-modal',
  templateUrl: './ontology-types-modal.component.html',
  styleUrls: ['./ontology-types-modal.component.css']
})
export class OntologyTypesModalComponent implements OnInit {
  
  @Input() id?: number;
  @Output() entity: EventEmitter<any> = new EventEmitter();
  submitBtnText: string;
  entityForm: FormGroup;
  

  constructor(public activeModal: NgbActiveModal, private formBuilder: FormBuilder, private entityService : OntologyEntityService) {}

  ngOnInit() {

    this.entityForm = this.formBuilder.group({
      entityId: [''],
      entityName: ['', Validators.required],
      entitySparqlQuery: ['', Validators.required]
    });

    if (this.id) {
      this.submitBtnText = 'Save Changes';
      this.getEntityById(this.id);
    } else {
      this.submitBtnText = 'Add Entity';
    }
  }

  getEntityById(id: number) {
    this.entityService.getEntityById(id).subscribe(
      (entity: OntologyEntity) => this.entityForm.patchValue(entity)
    );
    
  }

  onSubmit() {
    if (this.entityForm.valid) {
      this.entity.emit(this.entityForm.value as OntologyEntity);
      this.activeModal.close();
    }
  }

}
