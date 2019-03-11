import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterScanPage } from './register-scan.page';

describe('RegisterScanPage', () => {
  let component: RegisterScanPage;
  let fixture: ComponentFixture<RegisterScanPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterScanPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterScanPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
