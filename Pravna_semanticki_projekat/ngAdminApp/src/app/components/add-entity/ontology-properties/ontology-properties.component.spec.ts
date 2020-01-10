import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OntologyPropertiesComponent } from './ontology-properties.component';

describe('OntologyPropertiesComponent', () => {
  let component: OntologyPropertiesComponent;
  let fixture: ComponentFixture<OntologyPropertiesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OntologyPropertiesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OntologyPropertiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
