import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { OntologyEntity } from '../model/OntologyEntity.model';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Category':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class OntologyEntityService {


  constructor(private http: HttpClient) {}

  
  getEntities(): Observable<OntologyEntity[]> {
    return this.http.get<OntologyEntity[]>(environment.apiUrlOntologyEntity);
  }

  getEntityById(id: number): Observable<OntologyEntity> {
    return this.http.get<OntologyEntity>(environment.apiUrlOntologyEntity + '/' + id);
  }

  createEntity(entity: OntologyEntity): Observable<OntologyEntity> {
    return this.http.post<OntologyEntity>(environment.apiUrlOntologyEntity, entity, httpOptions);
  }

  updateEntity(entity: OntologyEntity): Observable<OntologyEntity> {
    return this.http.put<OntologyEntity>(environment.apiUrlOntologyEntity, entity, httpOptions);
  }

  deleteEntity(id: number): Observable<OntologyEntity> {
    return this.http.delete<OntologyEntity>(environment.apiUrlOntologyEntity + '/' + id);
  }

}
