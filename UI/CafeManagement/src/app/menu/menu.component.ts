import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'src/model/menu-item.model';
import { MenuService } from '../service/menu.service';



@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})

export class MenuComponent implements OnInit{

  menuItems!: MenuItem[];

  //menuItem: MenuItem = new MenuItem();
  
  constructor(private menuService: MenuService) {}

  ngOnInit(): void {
  this.loadMenuItems();
}

  loadMenuItems(): void{
    this.menuService.getMenuItem().subscribe(
      (items) => {
        this.menuItems = items;
      },
      (error) => {
        console.error('Error loading menu items:', error);
      }
    );
  }

}
