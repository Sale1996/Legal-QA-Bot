import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindEntitySecondModalComponent } from './find-entity-second-modal.component';

describe('FindEntitySecondModalComponent', () => {
  let component: FindEntitySecondModalComponent;
  let fixture: ComponentFixture<FindEntitySecondModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindEntitySecondModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindEntitySecondModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
