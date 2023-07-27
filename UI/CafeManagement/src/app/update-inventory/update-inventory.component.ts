import { Component, OnInit } from '@angular/core';
import { InventoryItem } from 'src/model/inventory-item.model';
import { InventoryService } from '../service/inventory.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-inventory',
  templateUrl: './update-inventory.component.html',
  styleUrls: ['./update-inventory.component.css']
})
export class UpdateInventoryComponent implements OnInit{
  id!: string;
  inventoryItems: InventoryItem[] = [];

  constructor(private inventoryService: InventoryService, private activatedRoute: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    //To get id from router link : activatedRoute 
    this.id = this.activatedRoute.snapshot.params['id'];
    //this.inventoryService.getInventoryItemById(this.id).subscribe(
      //data => { this.inventoryItems = data;
      //}, error => console.error("Error in getting inventory item by id")
   // );
  }

  updateInventoryItem(item: InventoryItem): void {
    this.inventoryService.updateInventoryItem(item.id, item).subscribe(
      updatedItem => {
        const index = this.inventoryItems.findIndex((x) => x.id === updatedItem.id);
        if (index !== -1) {
          this.inventoryItems[index] = updatedItem;
        }
        console.log(updatedItem);
      },
      (error) => {
        console.error('Error updating inventory item:', error);
      }
    );
  }

  onSubmit(){
    //this.inventoryService.updateInventoryItem().subscribe( data =>{
  }

  goToInventory(){
    this.router.navigate(['/inventory']);
  }


}
