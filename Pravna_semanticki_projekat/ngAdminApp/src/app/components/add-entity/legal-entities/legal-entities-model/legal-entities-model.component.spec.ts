import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LegalEntitiesModelComponent } from './legal-entities-model.component';

describe('LegalEntitiesModelComponent', () => {
  let component: LegalEntitiesModelComponent;
  let fixture: ComponentFixture<LegalEntitiesModelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LegalEntitiesModelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LegalEntitiesModelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
