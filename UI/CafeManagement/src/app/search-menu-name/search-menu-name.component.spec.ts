import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchMenuNameComponent } from './search-menu-name.component';

describe('SearchMenuNameComponent', () => {
  let component: SearchMenuNameComponent;
  let fixture: ComponentFixture<SearchMenuNameComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SearchMenuNameComponent]
    });
    fixture = TestBed.createComponent(SearchMenuNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
