import { HttpHeaders, HttpClient } from "@angular/common/http";

import { Injectable } from "@angular/core";

import { Observable } from "rxjs";

import { SparqlQuestion } from "../model/SparqlQuestion.model";

import { environment } from "src/environments/environment";
import { QuestionProperty } from "../model/QuestionProperty.model";
import { FindAnswer } from "../model/FindAnswer.model";
import { Answer } from "../model/Answer.model";

const httpOptions = {
  headers: new HttpHeaders({
    "Content-Category": "application/json"
  })
};

@Injectable({
  providedIn: "root"
})
export class SparqlQuestionService {
  constructor(private http: HttpClient) {}

  getQuestions(): Observable<SparqlQuestion[]> {
    return this.http.get<SparqlQuestion[]>(environment.apiUrlSparqlQuestion);
  }

  getAvailableQuestions(): Observable<SparqlQuestion[]> {
    return this.http.get<SparqlQuestion[]>(
      environment.apiUrlSparqlQuestion + "/available"
    );
  }

  getPropertiesOfQuestion(id: number): Observable<QuestionProperty[]> {
    return this.http.get<QuestionProperty[]>(
      environment.apiUrlSparqlQuestion + "/properties/" + id
    );
  }

  getFindAnswerObject(id: number): Observable<FindAnswer> {
    return this.http.get<FindAnswer>(
      environment.apiUrlSparqlQuestion + "/findAnswerParameters/" + id
    );
  }

  getSparqlQuestionById(id: number): Observable<SparqlQuestion> {
    return this.http.get<SparqlQuestion>(
      environment.apiUrlSparqlQuestion + "/" + id
    );
  }

  createSparqlQuestion(entity: SparqlQuestion): Observable<SparqlQuestion> {
    return this.http.post<SparqlQuestion>(
      environment.apiUrlSparqlQuestion,
      entity,
      httpOptions
    );
  }

  getAnswer(findAnswer: FindAnswer): Observable<Answer> {
    return this.http.post<Answer>(
      environment.apiUrlSparqlQuestion + "/getAnswer",
      findAnswer,
      httpOptions
    );
  }

  updateSparqlQuestion(entity: SparqlQuestion): Observable<SparqlQuestion> {
    return this.http.put<SparqlQuestion>(
      environment.apiUrlSparqlQuestion,
      entity,
      httpOptions
    );
  }

  deleteSparqlQuestion(id: number): Observable<SparqlQuestion> {
    return this.http.delete<SparqlQuestion>(
      environment.apiUrlSparqlQuestion + "/" + id
    );
  }
}
