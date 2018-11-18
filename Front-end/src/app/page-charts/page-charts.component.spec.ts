import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PageChartsComponent } from './page-charts.component';

describe('PageChartsComponent', () => {
  let component: PageChartsComponent;
  let fixture: ComponentFixture<PageChartsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PageChartsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PageChartsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
