import { HttpClient, HttpHeaders, HttpHeaderResponse, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import * as jwt_decode from 'jwt-decode';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Credentials } from '../model/Credentials.model';
import { User } from '../model/User.model';
import { RegistrationUser } from '../model/RegistrationUser.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  observe: 'response' as 'response'
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private userUrl = environment.apiUrlUser;

  constructor(
    private http: HttpClient,
    private router: Router
    ) { }

  login(credentials: Credentials) {
      return this.http.post(environment.apiUrlAuth + "/login", credentials, httpOptions).pipe(map(((res: HttpResponse<any>) => {
       // var access_token = JSON.stringify(res.body.accessToken);
        var access_token = res.body.accessToken;
       // access_token = access_token.replace(/^"(.*)"$/, '$1');
        localStorage.setItem('access_token', access_token);
        location.assign('/home');
      })));
  }

  register(user: RegistrationUser) {
    return this.http.post<User>(this.userUrl, user, httpOptions);
    // .pipe(map(((res: HttpResponse<any>) => {
    //   JSON.stringify(res.body);
    //   this.router.navigate(['/home']); // prebaciti na stranicu gde aktivira nalog
    // })));
  }

  logout() {

    localStorage.clear();
    location.assign('/');
      // return this.http.get(`${environment.apiUrlAuth}/logout`, httpOptions);
  }

  getTokenExpirationDate(token: string): Date {

      const decoded = jwt_decode(token);

      if (decoded.exp === undefined) {
        return null;
      }

      const date = new Date(0);
      date.setUTCSeconds(decoded.exp);
      return date;
  }

  isTokenExpired(token: string): boolean {

    const date = this.getTokenExpirationDate(token);

    if (date === undefined) {
      return false;
    } else {
      return !(date.valueOf() > new Date().valueOf());
    }
  }

  getEmailFromToken(token: string): string {

    if(token === null){
      return '';
    }

      const decoded = jwt_decode(token);

      if (decoded.sub === undefined) {
        return '';
      }

      return decoded.sub;


  }
}
