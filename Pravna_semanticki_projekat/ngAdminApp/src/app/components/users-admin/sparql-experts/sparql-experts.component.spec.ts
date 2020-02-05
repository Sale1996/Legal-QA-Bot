import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SparqlExpertsComponent } from './sparql-experts.component';

describe('SparqlExpertsComponent', () => {
  let component: SparqlExpertsComponent;
  let fixture: ComponentFixture<SparqlExpertsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SparqlExpertsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SparqlExpertsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
