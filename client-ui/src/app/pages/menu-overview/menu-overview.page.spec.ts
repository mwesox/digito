import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuOverviewPage } from './menu-overview.page';

describe('MenuOverviewPage', () => {
  let component: MenuOverviewPage;
  let fixture: ComponentFixture<MenuOverviewPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuOverviewPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuOverviewPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
