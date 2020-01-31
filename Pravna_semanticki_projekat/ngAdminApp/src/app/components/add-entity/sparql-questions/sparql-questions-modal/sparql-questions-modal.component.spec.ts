import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SparqlQuestionsModalComponent } from './sparql-questions-modal.component';

describe('SparqlQuestionsModalComponent', () => {
  let component: SparqlQuestionsModalComponent;
  let fixture: ComponentFixture<SparqlQuestionsModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SparqlQuestionsModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SparqlQuestionsModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
