import { Component, OnInit } from '@angular/core';
import { MenuService } from 'src/app/service/menu.service';
import { MenuItem } from 'src/model/menu-item.model';

@Component({
  selector: 'app-dashboard-menu',
  templateUrl: './dashboard-menu.component.html',
  styleUrls: ['./dashboard-menu.component.css']
})
export class DashboardMenuComponent implements OnInit {

  menuItems!: MenuItem[];
  
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

  createMenuItem(item: MenuItem): void{
    this.menuService.createMunuItem(item).subscribe(
      (createdItem) => {
        this.menuItems.push(createdItem);
      },
      (error) => {
        console.error('Error creating menu item:', error);
      }
    );
  }

  //Submit button action 
  onSubmit(){
    console.log(this.menuItems);
  }

  updateMenuItem(item: MenuItem): void{
    this.menuService.updateMenuItem(item.id, item).subscribe(
      (updatedItem) => {
        const index = this.menuItems.findIndex((x) => x.id === updatedItem.id);
        if (index !== -1){
          this.menuItems[index] = updatedItem;
        }
      },
      (error) => {
        console.error('Error updating menu item:', error);
      }
    );
  }

  deleteMenuItem(id: string): void {
    this.menuService.deleteMenuItem(id).subscribe(
      () => {
        this.menuItems = this.menuItems.filter((item) => item.id !== id);
      },
      (error) => {
        console.error('Error deleting menu item:', error);
      }
    );
  }


}
