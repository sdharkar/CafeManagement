import { Component, OnInit } from '@angular/core';
import { InventoryItem } from 'src/model/inventory-item.model';
import { InventoryService } from '../service/inventory.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit{

  inventoryItems!: InventoryItem[];

  inventoryItem: InventoryItem = new InventoryItem();

  constructor(private inventoryService: InventoryService, private router:Router) {}

  ngOnInit(): void {
    this.loadInventoryItems();
  }

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
    error => console.error("Error creating inventory item", error));
  }

  goToDashboard(){
    this.router.navigate(['/dashboard']);
  }


  //Submit button action 
  onSubmit(){
    console.log(this.inventoryItem);
    this.saveInventoryItem();
  }

  updateInventoryItem(item: InventoryItem): void {
    this.inventoryService.updateInventoryItem(item.id, item).subscribe(
      (updatedItem) => {
        const index = this.inventoryItems.findIndex((x) => x.id === updatedItem.id);
        if (index !== -1) {
          this.inventoryItems[index] = updatedItem;
        }
        this.router.navigate(['update-inventory', item.id]);
        console.log(updatedItem);
      },
      (error) => {
        console.error('Error updating inventory item:', error);
      }
    );
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
  confirmDelete(id: string): void{
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



  
}


