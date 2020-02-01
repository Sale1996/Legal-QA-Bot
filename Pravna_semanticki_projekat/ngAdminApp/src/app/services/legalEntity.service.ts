import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LegalEntity } from '../model/LegalEntity.model';
import { environment } from 'src/environments/environment';
import { SparqlQuestion } from '../model/SparqlQuestion.model';

const httpOptions = {
    headers: new HttpHeaders({
      'Content-Category':  'application/json'
    })
  };
  
  @Injectable({
    providedIn: 'root'
  })
  export class LegalEntityService {
  
  
    constructor(private http: HttpClient) {}
  
    
    getEntities(): Observable<LegalEntity[]> {
      return this.http.get<LegalEntity[]>(environment.apiUrlLegalEntity);
    }

    getQuestions(id: number): Observable<SparqlQuestion[]> {
        return this.http.get<SparqlQuestion[]>(environment.apiUrlLegalEntity + '/questions/' + id);
    }
    
  
    getEntityById(id: number): Observable<LegalEntity> {
      return this.http.get<LegalEntity>(environment.apiUrlLegalEntity + '/' + id);
    }
    
    createEntity(entity: LegalEntity): Observable<LegalEntity> {
      return this.http.post<LegalEntity>(environment.apiUrlLegalEntity, entity, httpOptions);
    }
  
    updateEntity(entity: LegalEntity): Observable<LegalEntity> {
      return this.http.put<LegalEntity>(environment.apiUrlLegalEntity, entity, httpOptions);
    }
  
    deleteEntity(id: number): Observable<LegalEntity> {
      return this.http.delete<LegalEntity>(environment.apiUrlLegalEntity + '/' + id);
    }
  
  
  
  }