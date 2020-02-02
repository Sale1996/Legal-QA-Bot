import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { LegalEntity } from 'src/app/model/LegalEntity.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FindEntityModalComponent } from './find-entity-modal/find-entity-modal.component';
import { FindEntity } from 'src/app/model/FindEntity.model';
import { LegalEntityService } from 'src/app/services/legalEntity.service';
import { SparqlQuestion } from 'src/app/model/SparqlQuestion.model';
import { SparqlQuestionService } from 'src/app/services/sparqlQuestion.service';
import { FindAnswer } from 'src/app/model/FindAnswer.model';
import { FindAnswerQuestionParameter } from 'src/app/model/FindAnswerQuestionParameter.model';

@Component({
  selector: 'app-code-book',
  templateUrl: './code-book.component.html',
  styleUrls: ['./code-book.component.css']
})
export class CodeBookComponent implements OnInit {

  chooseEntityForm: FormGroup;
  entities$: Observable<LegalEntity[]>;
  selectedEntity : LegalEntity;
  

  chooseQuestionForm: FormGroup;
  questions$: Observable<SparqlQuestion[]>;
  selectedQuestion: SparqlQuestion;

  findAnswerForm: FormGroup;
  findAnswer: FindAnswer;


  constructor(private formBuilder: FormBuilder, private modalService: NgbModal, private entityService : LegalEntityService, private questionService : SparqlQuestionService) { }

  ngOnInit() {

    this.getEntities();

    this.chooseEntityForm = this.formBuilder.group({
      entity: this.formBuilder.group({
        legalEntityId: [''],
        legalEntityName: ['']
      }),
    });

    this.chooseQuestionForm = this.formBuilder.group({
      question: this.formBuilder.group({
        sparqlQuestionId: [''],
        queryText: [''],
        sparqlQueryText: [''],
        legalEntity: ['']
      })
    });

  }

  getEntities() {
    this.entities$ = this.entityService.getEntities();
  }

  getQuestionsOfSelectedEntity(entityId : number){
    this.questions$ = this.entityService.getQuestions(entityId);
  }

  onSubmit(){
    
  }

  selectEntity(entityId : number){
    this.entityService.getEntityById(entityId).subscribe((data: LegalEntity) => {
      
      this.selectedEntity = data;
      this.getQuestionsOfSelectedEntity(data.legalEntityId);
    //  this.openQueryModal(data);
    } );
  }

  selectQuestion(questionId : number){
    this.questionService.getFindAnswerObject(questionId).subscribe((data: FindAnswer) =>{

        this.selectedQuestion = data.question;
        this.findAnswer = data;
        this.formateInputForm();

    });
  }

  formateInputForm(){
    this.findAnswerForm = this.formBuilder.group({
      question: [this.findAnswer.question],
      parameters: this.formBuilder.array(this.findAnswer.parameters.map(parameter => this.createMemberGroup(parameter)))
    });
  }

  createMemberGroup(findParameter : FindAnswerQuestionParameter){
    return this.formBuilder.group({
      ...findParameter,
      ...{ 
        questionProperty: {
          questionPropertyId: findParameter.questionProperty.questionPropertyId,
          questionPropertyName: findParameter.questionProperty.questionPropertyName,
          questionPropertyType: findParameter.questionProperty.questionPropertyType,
          sparqlQuestion: findParameter.questionProperty.sparqlQuestion
        },
        textInput: [findParameter.textInput],
        numberInput: [findParameter.numberInput],
        booleanInput: [findParameter.booleanInput],
        selectedEntity: [findParameter.selectedEntity]
      }
    });
  }

  getAnswer(){
    if (this.findAnswerForm.valid) {
      this.questionService.getAnswer(this.findAnswerForm.value as FindAnswer).subscribe();
    }
  }

  /*
  openQueryModal(entity : LegalEntity) {
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
  */

}
