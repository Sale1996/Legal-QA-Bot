import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindEntityModalComponent } from './find-entity-modal.component';

describe('FindEntityModalComponent', () => {
  let component: FindEntityModalComponent;
  let fixture: ComponentFixture<FindEntityModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindEntityModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindEntityModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
