import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/User.model';
import { RegistrationUser } from 'src/app/model/RegistrationUser.model';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  private RegisterForm: FormGroup;
  selectedRole: string;


  constructor(
    private authService: AuthService,
    private router: Router,
    private formBuilder: FormBuilder,
    private userService: UserService
  ) { }


  chooseUserRole(role: string){
    this.selectedRole = role;
  }

  ngOnInit() {
    this.RegisterForm = this.formBuilder.group({
      id: [''],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.email],
      username: ['', Validators.required],
      password: ['', Validators.required],
      password2: ['', Validators.required],
      role: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.RegisterForm.valid) {
      this.userService.registerUser(this.RegisterForm.value as RegistrationUser).subscribe(() => this.router.navigate(['/home']));
    }
  }
}
