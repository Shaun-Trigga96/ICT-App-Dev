import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewrentalsComponent } from './viewrentals.component';

describe('ViewrentalsComponent', () => {
  let component: ViewrentalsComponent;
  let fixture: ComponentFixture<ViewrentalsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewrentalsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewrentalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
