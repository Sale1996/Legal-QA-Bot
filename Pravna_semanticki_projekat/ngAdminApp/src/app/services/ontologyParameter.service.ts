import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { OntologyEntity } from '../model/OntologyEntity.model';
import { OntologyParameter } from '../model/OntologyParameter.model';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Category':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class OntologyParameterService {


  constructor(private http: HttpClient) {}

  
  getParameters(): Observable<OntologyParameter[]> {
    return this.http.get<OntologyParameter[]>(environment.apiUrlOntologyParameter);
  }

  getParameterById(id: number): Observable<OntologyParameter> {
    return this.http.get<OntologyParameter>(environment.apiUrlOntologyParameter + '/' + id);
  }

  createParameter(parameter: OntologyParameter): Observable<OntologyParameter> {
    return this.http.post<OntologyParameter>(environment.apiUrlOntologyParameter, parameter, httpOptions);
  }

  updateParameter(parameter: OntologyParameter): Observable<OntologyParameter> {
    return this.http.put<OntologyParameter>(environment.apiUrlOntologyParameter, parameter, httpOptions);
  }

  deleteParameter(id: number): Observable<OntologyParameter> {
    return this.http.delete<OntologyParameter>(environment.apiUrlOntologyParameter + '/' + id);
  }

}