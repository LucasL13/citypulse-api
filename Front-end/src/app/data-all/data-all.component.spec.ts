import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataAllComponent } from './data-all.component';

describe('DataAllComponent', () => {
  let component: DataAllComponent;
  let fixture: ComponentFixture<DataAllComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DataAllComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
