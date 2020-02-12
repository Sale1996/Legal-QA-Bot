import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/model/User.model';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  userEmail: string;
  loggedUser: User;

  constructor(private authService: AuthService, private userService: UserService) { }

  ngOnInit() {
   // this.getUser();
  }

  isLoggedIn(): boolean {
    if (localStorage.hasOwnProperty('access_token')) {
      return true;
    } else {
      return false;
    }
  }


  getUser() {
    this.userService.getLoggedUser().subscribe(
      (user: User) => {
        this.loggedUser = user;      
      }
    )
  }

  logout() {
    this.authService.logout();

  }

}
