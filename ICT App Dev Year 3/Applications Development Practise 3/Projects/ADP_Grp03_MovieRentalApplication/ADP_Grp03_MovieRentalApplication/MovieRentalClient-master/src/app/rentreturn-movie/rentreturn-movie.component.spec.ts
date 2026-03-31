import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RentreturnMovieComponent } from './rentreturn-movie.component';

describe('RentreturnMovieComponent', () => {
  let component: RentreturnMovieComponent;
  let fixture: ComponentFixture<RentreturnMovieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RentreturnMovieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RentreturnMovieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
