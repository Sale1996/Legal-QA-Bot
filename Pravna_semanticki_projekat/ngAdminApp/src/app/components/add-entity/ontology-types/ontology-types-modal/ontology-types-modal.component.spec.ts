import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OntologyTypesModalComponent } from './ontology-types-modal.component';

describe('OntologyTypesModalComponent', () => {
  let component: OntologyTypesModalComponent;
  let fixture: ComponentFixture<OntologyTypesModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OntologyTypesModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OntologyTypesModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
