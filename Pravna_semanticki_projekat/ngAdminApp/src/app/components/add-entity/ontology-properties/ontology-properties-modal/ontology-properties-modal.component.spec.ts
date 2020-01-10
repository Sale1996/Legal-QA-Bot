import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OntologyPropertiesModalComponent } from './ontology-properties-modal.component';

describe('OntologyPropertiesModalComponent', () => {
  let component: OntologyPropertiesModalComponent;
  let fixture: ComponentFixture<OntologyPropertiesModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OntologyPropertiesModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OntologyPropertiesModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
