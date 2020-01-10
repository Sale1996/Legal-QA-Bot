import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OntologyTypesComponent } from './ontology-types.component';

describe('OntologyTypesComponent', () => {
  let component: OntologyTypesComponent;
  let fixture: ComponentFixture<OntologyTypesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OntologyTypesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OntologyTypesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
