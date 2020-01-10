import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Observable } from 'rxjs';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { OntologyEntity } from 'src/app/model/OntologyEntity.model';

@Component({
  selector: 'app-find-entity-modal',
  templateUrl: './find-entity-modal.component.html',
  styleUrls: ['./find-entity-modal.component.css']
})
export class FindEntityModalComponent implements OnInit {

  @Input() creation?: boolean;
  @Input() entity: OntologyEntity;
  @Output() price: EventEmitter<any> = new EventEmitter();
  priceForm: FormGroup;
  //prices$: Observable<Price[]>;

  constructor(public activeModal: NgbActiveModal, private formBuilder: FormBuilder) { }

  ngOnInit() {

    this.priceForm = this.formBuilder.group({
      id: [-1],
      dateFrom: [''],
      dateTo: [''],
      amount: ['']

    });

    this.getAllPricesOfAccommodationUnit();

  }


  deletePrice(id: number) {
    /*
    this.priceService.deletePrice(id).subscribe(() => {
      this.getAllPricesOfAccommodationUnit();
    })*/
  }

  getAllPricesOfAccommodationUnit() {
    //this.prices$ = this.priceService.getPrices(this.unit.accommodationUnitId);
  }

  deletePriceFromAccommodationUnit(priceIdd: number) {
    /*
    this.priceService.deletePrice(priceIdd).subscribe((data) => {
      this.getAllPricesOfAccommodationUnit();
    });
    */
  }

  createPriceOfAccommodationUnit() {
   // this.priceService.createPrice(this.priceForm.value as Price).subscribe((data) => {
  //    this.getAllPricesOfAccommodationUnit();
  //  });
  }

  onSubmit() {
    if (this.priceForm.valid) {
     // const newPrice = (this.priceForm.value as Price);
     // newPrice.accommodationUnit = this.unit;
     // this.priceService.createPrice(newPrice).subscribe((data) => {
     //   this.getAllPricesOfAccommodationUnit();
     // });

    }
  }

  closeModal() {
    this.activeModal.close();
    if (this.creation) {
      this.price.emit();
    }
  }



}