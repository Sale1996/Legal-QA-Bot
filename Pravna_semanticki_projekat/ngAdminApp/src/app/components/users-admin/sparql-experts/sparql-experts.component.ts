import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/User.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { UserService } from 'src/app/services/user.service';
import { ConfirmationModalComponent } from 'src/app/_shared/confirmation-modal/confirmation-modal.component';
import { UserModalComponent } from '../user-modal/user-modal.component';
import { RegistrationUser } from 'src/app/model/RegistrationUser.model';

@Component({
  selector: 'app-sparql-experts',
  templateUrl: './sparql-experts.component.html',
  styleUrls: ['./sparql-experts.component.css']
})
export class SparqlExpertsComponent implements OnInit {


  users$: Observable<User[]>;

  constructor(private modalService: NgbModal, private userService : UserService) { }

  ngOnInit() {
   this.getUsers();
  }

  getUsers() {
   this.users$ = this.userService.getSparqlSpecialistUsers();
  }

  
  enableUser(id) {
    this.userService.enableUser(id).subscribe(
      () => {
        this.getUsers();
      }
    );
  }

  deleteUser(user: User) {
    const deleteModalRef = this.modalService.open(ConfirmationModalComponent,
      {
        centered: true,
        backdropClass: 'custom-modal-backdrop'
      });
    deleteModalRef.componentInstance.title = 'Delete Sparql Expert User';
    deleteModalRef.componentInstance.message = 'Are you sure you want to delete ' + user.username + '?';
    deleteModalRef.componentInstance.answer.subscribe(
      (answer: boolean) => {
        if (answer) {
          this.userService.deleteUser(user.id).subscribe(
            () => {
              this.getUsers();
            }
          );
        }
      }
    );
  }

  restoreUser(user: User) {
    const restoreModalRef = this.modalService.open(ConfirmationModalComponent,
      {
        centered: true,
        backdropClass: 'custom-modal-backdrop'
      });
      restoreModalRef.componentInstance.title = 'Restore Sparql Expert User';
      restoreModalRef.componentInstance.message = 'Are you sure you want to restore ' + user.username + '?';
      restoreModalRef.componentInstance.answer.subscribe(
      (answer: boolean) => {
        if (answer) {
          this.userService.restoreUser(user.id).subscribe(
            () => {
              this.getUsers();
            }
          );
        }
      }
    );
  }

  openUserModal(id?: number) {
    
    const userModalRef = this.modalService.open(UserModalComponent,
      {
        centered: true,
        backdropClass: 'custom-modal-backdrop'
      });

    if (id) {
      userModalRef.componentInstance.id = id;
    }
    userModalRef.componentInstance.user.subscribe(
      (user: RegistrationUser) => {
          if (user.id) {
          } else {  
           this.userService.registerUser(user).subscribe(
                () => {
                  this.getUsers();
                }
              );
             
          }
      }
    );
    
  }

}
