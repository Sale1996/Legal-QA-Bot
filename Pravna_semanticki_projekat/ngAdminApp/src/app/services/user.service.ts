import { Injectable } from '@angular/core';
import { User } from '../model/User.model';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { RegistrationUser } from '../model/RegistrationUser.model';
import { HttpHeaders, HttpClient } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Category':  'application/json'
  })
};

@Injectable({
    providedIn: 'root'
  })
export class UserService{

  constructor(private http: HttpClient) {}
  
    getLoggedUser(): Observable<User>{
      return this.http.get<User>(environment.apiUrlUser + "/whoami");
    }

    getAdminUsers(): Observable<User[]> {
      return this.http.get<User[]>(environment.apiUrlUser + "/getAdmins");
    }
    getLawyerUsers(): Observable<User[]> {
      return this.http.get<User[]>(environment.apiUrlUser + "/getLawyers");
    }
    getSparqlSpecialistUsers(): Observable<User[]> {
      return this.http.get<User[]>(environment.apiUrlUser + "/getSparqlSpecialists");
    }

    registerUser(user : RegistrationUser) : Observable<User>{
      return this.http.post<User>(environment.apiUrlAuth + '/register', user, httpOptions)
    }

    updateUserInfo(user: User): Observable<User>{
      return this.http.put<User>(environment.apiUrlUser, user, httpOptions);
    }

    deleteUser(id: number){
      return this.http.delete(environment.apiUrlUser + '/' + id);
    }

    restoreUser(id: number): Observable<User>{
      return this.http.put<User>(environment.apiUrlUser + '/restoreUser/', id, httpOptions);
    }
  
    enableUser(id: number){
      return this.http.put(environment.apiUrlUser + '/enableUser/', id, httpOptions);
    }

}