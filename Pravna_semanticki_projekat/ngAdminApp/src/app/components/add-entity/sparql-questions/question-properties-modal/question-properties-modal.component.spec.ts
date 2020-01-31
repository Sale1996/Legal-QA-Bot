import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionPropertiesModalComponent } from './question-properties-modal.component';

describe('QuestionPropertiesModalComponent', () => {
  let component: QuestionPropertiesModalComponent;
  let fixture: ComponentFixture<QuestionPropertiesModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuestionPropertiesModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuestionPropertiesModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
