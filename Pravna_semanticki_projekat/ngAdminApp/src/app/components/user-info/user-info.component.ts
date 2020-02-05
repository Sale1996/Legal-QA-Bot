import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';

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

  constructor(private formBuilder: FormBuilder, private authService: AuthService) { }

  ngOnInit() {

    this.userForm = this.formBuilder.group({
      id: [''],
      firstName: ['', [Validators.required, Validators.maxLength(50)]],
      lastName: ['', [Validators.required, Validators.maxLength(50)]],
      email: [{value: '', disabled: 'true'}]
    });

    this.passwordForm = this.formBuilder.group({
      password1: [''],
      password2: ['']
    });

  //  this.getAgentById(this.authService.getEmailFromToken(localStorage.getItem('access_token')));
  }

  /*
  getAgentById(email: string) {
    this.agentService.getAgentByEmail(email).subscribe(
      (agent: Agent) => {
        this.userForm.patchValue(agent);
        this.agentFullName = agent.firstName + ' ' + agent.lastName;
        this.agentId = agent.id;
      }
    )
  }
*/
  onSubmit() {
    /*
    if (this.agentForm.valid) {
      this.agentService.updateAgent(this.agentForm.value as Agent).subscribe(
        (agent: Agent) => {
          this.agentFullName = agent.firstName + ' ' + agent.lastName;
        }
      );
    }
    */
  }

  onSubmitPassword() {
    /*
    if (this.passwordForm.valid) {
      const updatePassword: UpdatePassword = {
        email: this.authService.getEmailFromToken(localStorage.getItem('access_token')),
        oldPassword: this.passwordForm.value.password1,
        newPassword: this.passwordForm.value.password2
      };

      this.agentService.changePassword(updatePassword).subscribe(
        () => {
        }
      );
      
      

    } */
  }

}
