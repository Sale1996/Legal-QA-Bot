import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { QuestionProperty } from '../model/QuestionProperty.model';
import { environment } from 'src/environments/environment';

const httpOptions = {
    headers: new HttpHeaders({
      'Content-Category':  'application/json'
    })
  };
  
  @Injectable({
    providedIn: 'root'
  })
  export class QuestionPropertyService {
  
  
    constructor(private http: HttpClient) {}
  
    
    getQuestionProperties(): Observable<QuestionProperty[]> {
      return this.http.get<QuestionProperty[]>(environment.apiUrlQuestionProperty);
    }
      
    getQuestionPropertyById(id: number): Observable<QuestionProperty> {
      return this.http.get<QuestionProperty>(environment.apiUrlQuestionProperty + '/' + id);
    }
    
    createQuestionProperty(entity: QuestionProperty): Observable<QuestionProperty> {
      return this.http.post<QuestionProperty>(environment.apiUrlQuestionProperty, entity, httpOptions);
    }
  
    updateQuestionProperty(entity: QuestionProperty): Observable<QuestionProperty> {
      return this.http.put<QuestionProperty>(environment.apiUrlQuestionProperty, entity, httpOptions);
    }
  
    deleteQuestionProperty(id: number): Observable<QuestionProperty> {
      return this.http.delete<QuestionProperty>(environment.apiUrlQuestionProperty + '/' + id);
    }
  
  
  
  }