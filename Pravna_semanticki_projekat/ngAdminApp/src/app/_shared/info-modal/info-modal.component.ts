import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-info-modal',
  templateUrl: './info-modal.component.html',
  styleUrls: ['./info-modal.component.css']
})
export class InfoModalComponent implements OnInit {


  @Input() title: string;
  @Input() message: string;
  @Output() answer: EventEmitter<any> = new EventEmitter();

  constructor(private activeModal: NgbActiveModal) { }

  ngOnInit() {
  }

  userAnswer(yes: boolean) {
      this.activeModal.close();
  }
}
