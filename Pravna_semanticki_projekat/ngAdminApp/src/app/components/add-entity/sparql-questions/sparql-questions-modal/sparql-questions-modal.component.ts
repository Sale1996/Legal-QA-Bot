import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { LegalEntity } from 'src/app/model/LegalEntity.model';
import { SparqlQuestionService } from 'src/app/services/sparqlQuestion.service';
import { SparqlQuestion } from 'src/app/model/SparqlQuestion.model';
import { Observable } from 'rxjs/internal/Observable';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { LegalEntityService } from 'src/app/services/legalEntity.service';
import { OntologyParameter } from 'src/app/model/OntologyParameter.model';

@Component({
  selector: 'app-sparql-questions-modal',
  templateUrl: './sparql-questions-modal.component.html',
  styleUrls: ['./sparql-questions-modal.component.css']
})
export class SparqlQuestionsModalComponent implements OnInit {


  @Input() id?: number;
  @Output() question: EventEmitter<any> = new EventEmitter();
  submitBtnText: string;
  questionForm: FormGroup;
  entities$: Observable<LegalEntity[]>;
  selectedEntity : LegalEntity;


  constructor(public activeModal: NgbActiveModal, private formBuilder: FormBuilder, private entityService : LegalEntityService, private questionService : SparqlQuestionService) {}

  ngOnInit() {

    this.getEntities();

    this.questionForm = this.formBuilder.group({
      sparqlQuestionId: [''],
      queryText: ['', Validators.required],
      sparqlQueryText: ['', Validators.required],
      entityId: [''],
      legalEntity: [],
    });

    if (this.id) {
      this.submitBtnText = 'Save Changes';
      this.getQuestionById(this.id);
    } else {
      this.submitBtnText = 'Add Question';
    }
  }

  getEntities() {
    this.entities$ = this.entityService.getEntities();
  }

  getQuestionById(id: number) {
    
    this.questionService.getSparqlQuestionById(id).subscribe(
      (question: SparqlQuestion) => {
        this.questionForm.patchValue(question);
        this.selectEntity(question.legalEntity.legalEntityId);
        this.questionForm.patchValue({entityId: question.legalEntity.legalEntityId})

      }
    );
    
  }

  selectEntity(entityId : number){
    this.entityService.getEntityById(entityId).subscribe((data: LegalEntity) => this.selectedEntity = data );
  }


  onSubmit() {
    
    if (this.questionForm.valid) {
      var return_value = this.questionForm.value as SparqlQuestion;
      return_value.legalEntity = this.selectedEntity;
      this.question.emit(return_value);
      this.activeModal.close();
    }
    
  }
}
