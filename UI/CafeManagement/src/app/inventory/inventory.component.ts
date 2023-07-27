import { Component, OnInit } from '@angular/core';
import { InventoryItem } from 'src/model/inventory-item.model';
import { InventoryService } from '../service/inventory.service';
import { Router } from '@angular/router';

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

  
  createInventoryItem(item: InventoryItem): void {
    this.inventoryService.createInventoryItem(item).subscribe(
      createdItem => {
        this.inventoryItems.push(createdItem);
        console.log(createdItem);
      },
      error => {
        console.error('Error creating inventory item:', error);
      }
    );
  }

  //Submit button action 
  onSubmit(){
    console.log(this.inventoryItems);
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

  deleteInventoryItem(id: string): void {
    this.inventoryService.deleteInventoryItem(id).subscribe(
      () => {
        this.inventoryItems = this.inventoryItems.filter((item) => item.id !== id);
      },
      (error) => {
        console.error('Error deleting inventory item:', error);
      }
    );
  }

}
