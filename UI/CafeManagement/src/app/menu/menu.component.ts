import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'src/model/menu-item.model';
import { MenuService } from '../service/menu.service';



@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent{
  
  menuItems: MenuItem[] = [];

  constructor(private menuService: MenuService){
    this.loadMenuItems();
  }

  loadMenuItems(): void {
    this.menuService.getMenuItem().subscribe(
      (menuItems) => {
        this.menuItems = menuItems;
      },
      (error: any) => {
        console.error('error loading menu items', error);
      }
    );
  }

  

}
