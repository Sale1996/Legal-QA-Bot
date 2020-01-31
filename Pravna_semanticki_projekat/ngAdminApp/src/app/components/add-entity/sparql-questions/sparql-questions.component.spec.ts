import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SparqlQuestionsComponent } from './sparql-questions.component';

describe('SparqlQuestionsComponent', () => {
  let component: SparqlQuestionsComponent;
  let fixture: ComponentFixture<SparqlQuestionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SparqlQuestionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SparqlQuestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
