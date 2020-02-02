import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { SparqlQuestion } from 'src/app/model/SparqlQuestion.model';
import { QuestionProperty } from 'src/app/model/QuestionProperty.model';
import { QuestionPropertyService } from 'src/app/services/questionProperty.service';
import { SparqlQuestionService } from 'src/app/services/sparqlQuestion.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-question-properties-modal',
  templateUrl: './question-properties-modal.component.html',
  styleUrls: ['./question-properties-modal.component.css']
})
export class QuestionPropertiesModalComponent implements OnInit {

  @Input() sparqlQuestion: SparqlQuestion;
  @Output() property: EventEmitter<any> = new EventEmitter();
  propertyForm: FormGroup;
  properties$: Observable<QuestionProperty[]>;
  selectedPropertyType: string;


  constructor(public activeModal: NgbActiveModal, private formBuilder: FormBuilder, private propertyService: QuestionPropertyService, private questionService: SparqlQuestionService) { }

  ngOnInit() {

    this.propertyForm = this.formBuilder.group({
      questionPropertyId: [-1],
      questionPropertyName: ['', Validators.required],
      questionPropertyType: ['', Validators.required],
      sparqlQuestion: []

    });

    this.getAllPropertiesOfSparqlQuestion();

  }

  choosePropertyType(propertyType: string){
    this.selectedPropertyType = propertyType;
  }



  deleteProperty(id: number) {
    this.propertyService.deleteQuestionProperty(id).subscribe(() => {
      this.getAllPropertiesOfSparqlQuestion();
    })
  }

  getAllPropertiesOfSparqlQuestion() {
    this.properties$ = this.questionService.getPropertiesOfQuestion(this.sparqlQuestion.sparqlQuestionId);
  }

  onSubmit() {
    if (this.propertyForm.valid) {
      const newProperty = (this.propertyForm.value as QuestionProperty);
      newProperty.sparqlQuestion = this.sparqlQuestion;
      this.propertyService.createQuestionProperty(newProperty).subscribe((data) => {
        this.getAllPropertiesOfSparqlQuestion();
      });

    }
  }

  closeModal() {
    this.activeModal.close();
      this.property.emit();
    
  }

}
