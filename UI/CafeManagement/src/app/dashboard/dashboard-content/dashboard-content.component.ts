import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { InventoryService } from 'src/app/service/inventory.service';
import { MenuService } from 'src/app/service/menu.service';
import { InventoryItem } from 'src/model/inventory-item.model';
import { MenuItem } from 'src/model/menu-item.model';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-dashboard-content',
  templateUrl: './dashboard-content.component.html',
  styleUrls: ['./dashboard-content.component.css']
})
export class DashboardContentComponent implements OnInit {

  menuItems!: MenuItem[];

  menuItem : MenuItem = new MenuItem();
  
  constructor(private menuService: MenuService, private router: Router,private inventoryService: InventoryService) {}

  ngOnInit(): void {
    this.loadMenuItems();
    this.loadInventoryItems();
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
    this.menuService.createMenuItem(this.menuItem).subscribe(
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

  // Delete menu Item
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

  //Update menu item
  updateMenuItem(id: string){
    this.router.navigate(['update-menu', id]);
  }

  //display content
  showAddMenuItem: boolean = false;
  toggleAddMenuItem(){
    this.showAddMenuItem = !this.showAddMenuItem;
  }

  showAllMenuItem: boolean = false;
  toggleAllMenuItem(){
    this.showAllMenuItem =!this.showAllMenuItem;
  }




  //Inventory
  inventoryItems!: InventoryItem[];

  inventoryItem: InventoryItem = new InventoryItem();

 

  loadInventoryItems(): void {
    this.inventoryService.getInventoryItem().subscribe(
      items => {
        this.inventoryItems = items;
        console.log("loading inventory items");
      },
      error => {
        console.error('Error loading inventory items:', error);
      }
    );
  }

  saveInventoryItem(){
    this.inventoryService.createInventoryItem(this.inventoryItem).subscribe(
      data =>{
      console.log(data);
      this.goToDashboardInventory();
      //Dialog box
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Inventroy Item created successfully!!!',
        showConfirmButton: false,
        timer: 1500
      })
    },
    error => console.error("Error creating inventory item", error));
  }

  goToDashboardInventory(){
    this.router.navigate(['/dashboard']);
  }


  //Submit button action 
  onSubmitInventory(){
    console.log(this.inventoryItem);
    this.saveInventoryItem();
  }

  //Update inventory router link
  updateInventoryItem(id: string){
    this.router.navigate(['update-inventory', id]);
  }

  deleteInventoryItem(id: string){
    this.inventoryService.deleteInventoryItem(id).subscribe(
      (data: any) => {
        console.log(data, "Inventory Item deleated");
        this.loadInventoryItems();
      },
      (error) => {
        console.error('Error deleting inventory item:', error);
      }
    );
  }


  //method to confirm the deletion before calling the service
  confirmDeleteInventory(id: string): void{
    Swal.fire({
      title: "Confirm Deletion",
      text: "Are you sure, you want to delete this inventory item?",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.deleteInventoryItem(id);
      }
    });
  }

  //display content
  showAddInventory: boolean = false;
  toggleAddInventory(){
    this.showAddInventory = !this.showAddInventory;
  }

  showAllInventory: boolean = false;
  toggleAllInventory(){
    this.showAllInventory =!this.showAllInventory;
  }





}
