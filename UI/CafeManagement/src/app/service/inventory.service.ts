import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { InventoryItem } from 'src/model/inventory-item.model';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {

  private baseUrl2 = 'http://localhost:9612/cafe/inventory/item';

  constructor(private http: HttpClient) { }


  //Create inventory item
  createInventoryItem(item: InventoryItem): Observable<InventoryItem>{
    return this.http.post<InventoryItem>(this.baseUrl2, item);
  }

  //Get inventory items
  getInventoryItem(): Observable<InventoryItem[]>{
    return this.http.get<InventoryItem[]>(this.baseUrl2);
  }

  //Get inventory item by id
  getInventoryItemById(id: string): Observable<InventoryItem>{
    return this.http.get<InventoryItem>(`${this.baseUrl2}/${id}`);
  }

  //Update inventory item
  updateInventoryItem(id: string, item: InventoryItem): Observable<InventoryItem>{
    return this.http.put<InventoryItem>(`${this.baseUrl2}/${id}`, item);
  }


  //Delete inventory item
  deleteInventoryItem(id: string): Observable<void>{
    return this.http.delete<void>(`${this.baseUrl2}/${id}`);
  }
}
