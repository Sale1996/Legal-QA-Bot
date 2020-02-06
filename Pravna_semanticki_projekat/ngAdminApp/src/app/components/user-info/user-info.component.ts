import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/model/User.model';
import { ChangePassword } from 'src/app/model/ChangePassword.model';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {


  userForm: FormGroup;
  passwordForm: FormGroup;
  userFullName: string;
  agentId: number;
  agentEmail: string;

  constructor(private formBuilder: FormBuilder, private authService: AuthService, private userService : UserService) { }

  ngOnInit() {

    this.userForm = this.formBuilder.group({
      id: [''],
      firstName: ['', [Validators.required, Validators.maxLength(50)]],
      lastName: ['', [Validators.required, Validators.maxLength(50)]],
      email: ['', Validators.email]
    });

    this.passwordForm = this.formBuilder.group({
      oldPassword: [''],
      newPassword: ['']
    });

    this.getUser();

    //  this.getAgentById(this.authService.getEmailFromToken(localStorage.getItem('access_token')));
  }


  getUser() {

    this.userService.getLoggedUser().subscribe(
      (user: User) => {
        this.userForm.patchValue(user);
        this.userFullName = user.username;
        
      }
    )
    /*
    this.agentService.getAgentByEmail(email).subscribe(
      (agent: Agent) => {
        this.userForm.patchValue(agent);
        this.agentFullName = agent.firstName + ' ' + agent.lastName;
        this.agentId = agent.id;
      }
    )
    */
  }

  onSubmit() {
    
    if (this.userForm.valid) {
      this.userService.updateUserInfo(this.userForm.value as User).subscribe();
    }
    
  }

  onSubmitPassword() {
    
    if (this.passwordForm.valid) {
      this.authService.changePassword(this.passwordForm.value as ChangePassword).subscribe();      
    } 
  }

}
