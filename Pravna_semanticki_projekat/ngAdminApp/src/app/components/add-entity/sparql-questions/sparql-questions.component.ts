import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { SparqlQuestion } from 'src/app/model/SparqlQuestion.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { SparqlQuestionService } from 'src/app/services/sparqlQuestion.service';
import { ConfirmationModalComponent } from 'src/app/_shared/confirmation-modal/confirmation-modal.component';
import { LegalEntitiesModelComponent } from '../legal-entities/legal-entities-model/legal-entities-model.component';
import { SparqlQuestionsModalComponent } from './sparql-questions-modal/sparql-questions-modal.component';

@Component({
  selector: 'app-sparql-questions',
  templateUrl: './sparql-questions.component.html',
  styleUrls: ['./sparql-questions.component.css']
})
export class SparqlQuestionsComponent implements OnInit {


  questions$: Observable<SparqlQuestion[]>;

  constructor(private modalService: NgbModal, private questionService : SparqlQuestionService) { }

  ngOnInit() {
    this.getQuestions();
  }

  getQuestions() {
    this.questions$ = this.questionService.getQuestions();
  }

  deleteQuestion(question: SparqlQuestion) {
    const deleteModalRef = this.modalService.open(ConfirmationModalComponent,
      {
        centered: true,
        backdropClass: 'custom-modal-backdrop'
      });
    deleteModalRef.componentInstance.title = 'Delete question';
    deleteModalRef.componentInstance.message = 'Are you sure you want to delete ' + '"' + question.queryText + ' " ?';
    deleteModalRef.componentInstance.answer.subscribe(
      (answer: boolean) => {
        if (answer) {
          this.questionService.deleteSparqlQuestion(question.sparqlQuestionId).subscribe(
            () => {
              this.getQuestions();
            }
          );
        }
      }
    );
  }

  openQuestionModal(id?: number) {
    const agentModalRef = this.modalService.open(SparqlQuestionsModalComponent,
      {
        centered: true,
        backdropClass: 'custom-modal-backdrop'
      });

    if (id) {
      agentModalRef.componentInstance.id = id;
    }
    agentModalRef.componentInstance.question.subscribe(
      (question: SparqlQuestion) => {
          if (question.sparqlQuestionId) {
            this.questionService.updateSparqlQuestion(question).subscribe(
              () => {
                this.getQuestions();
              }
            );
          } else {  
            this.questionService.createSparqlQuestion(question).subscribe(
                () => {
                  this.getQuestions();
                }
              );
              
          }
      }
    );
  }
}
