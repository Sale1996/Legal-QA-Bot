import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { LegalEntityService } from 'src/app/services/legalEntity.service';
import { LegalEntity } from 'src/app/model/LegalEntity.model';

@Component({
  selector: 'app-legal-entities-model',
  templateUrl: './legal-entities-model.component.html',
  styleUrls: ['./legal-entities-model.component.css']
})
export class LegalEntitiesModelComponent implements OnInit {

  @Input() id?: number;
  @Output() entity: EventEmitter<any> = new EventEmitter();
  submitBtnText: string;
  entityForm: FormGroup;
  

  constructor(public activeModal: NgbActiveModal, private formBuilder: FormBuilder, private entityService : LegalEntityService) {}

  ngOnInit() {

    this.entityForm = this.formBuilder.group({
      legalEntityId: [''],
      legalEntityName: ['', Validators.required],
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
      (entity: LegalEntity) => this.entityForm.patchValue(entity)
    );
    
  }

  onSubmit() {
    if (this.entityForm.valid) {
      this.entity.emit(this.entityForm.value as LegalEntity);
      this.activeModal.close();
    }
  }
}
