import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuService } from 'src/app/service/menu.service';
import { MenuItem } from 'src/model/menu-item.model';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-dashboard-menu',
  templateUrl: './dashboard-menu.component.html',
  styleUrls: ['./dashboard-menu.component.css']
})
export class DashboardMenuComponent implements OnInit {

  menuItems!: MenuItem[];

  menuItem : MenuItem = new MenuItem();
  
  constructor(private menuService: MenuService, private router: Router) {}

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

  createMenuItem(){
    this.menuService.createMunuItem(this.menuItem).subscribe(
      createdItem => {
        console.log(createdItem);
        this.goToDashboard();
        //Dialog box
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Inventroy Item created successfully!!!',
          showConfirmButton: false,
          timer: 1500
        })
      },
      error => {
        console.error('Error creating menu item:', error);
      }
    );
  }

  goToDashboard(){
    this.router.navigate(['/dashboard']);
  }

  //Submit button action 
  onSubmit(){
    console.log(this.menuItems);
    this.createMenuItem();
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

  //method to confirm the deletion before calling the service
  confirmDelete(id: string): void{
    Swal.fire({
      title: "Confirm Deletion",
      text: "Are you sure, you want to delete this menu item?",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.deleteMenuItem(id);
      }
    });

  
  }


}
