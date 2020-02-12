import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { UserService } from 'src/app/services/user.service';
import { RegistrationUser } from 'src/app/model/RegistrationUser.model';

@Component({
  selector: 'app-user-modal',
  templateUrl: './user-modal.component.html',
  styleUrls: ['./user-modal.component.css']
})
export class UserModalComponent implements OnInit {

  @Input() id?: number;
  @Output() user: EventEmitter<any> = new EventEmitter();
  RegisterForm: FormGroup;
  selectedRole: string;
  

  constructor(public activeModal: NgbActiveModal, private formBuilder: FormBuilder, private userService : UserService) {}

  ngOnInit() {

    this.RegisterForm = this.formBuilder.group({
      id: [''],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.email],
      username: ['', Validators.required],
      password: ['', Validators.required],
      password2: ['', Validators.required],
      role: ['', Validators.required],
      deleted: [false]
    });

    if (this.id) {
     // this.getEntityById(this.id);
    }
  }

  chooseUserRole(role: string){
    this.selectedRole = role;
  }


  getUserById(id: number) {
    /*
    this.userService(id).subscribe(
      (entity: LegalEntity) => this.entityForm.patchValue(entity)
    );
    */
    
  }

  onSubmit() {
    
    if (this.RegisterForm.valid) {
      this.user.emit(this.RegisterForm.value as RegistrationUser);
      this.activeModal.close();
    }
    
  }
}
