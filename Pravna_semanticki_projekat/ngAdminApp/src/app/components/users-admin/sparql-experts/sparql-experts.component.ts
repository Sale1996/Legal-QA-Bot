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
   // this.getUsers();
  }

  getUsers() {
   // this.entities$ = this.entityService.getEntities();
  }

  deleteUser(user: User) {
    const deleteModalRef = this.modalService.open(ConfirmationModalComponent,
      {
        centered: true,
        backdropClass: 'custom-modal-backdrop'
      });
    deleteModalRef.componentInstance.title = 'Delete Admin User';
    deleteModalRef.componentInstance.message = 'Are you sure you want to delete ' + user.username + '?';
    deleteModalRef.componentInstance.answer.subscribe(
      (answer: boolean) => {
        if (answer) {
          /*this.entityService.deleteEntity(entity.legalEntityId).subscribe(
            () => {
              this.getEntities();
            }
          );
          */
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
           /* this.entityService.updateEntity(entity).subscribe(
              () => {
                this.getEntities();
              }
            ); */
          } else {  
           /* this.entityService.createEntity(entity).subscribe(
                () => {
                  this.getEntities();
                }
              );
             */ 
          }
      }
    );
  }
}
