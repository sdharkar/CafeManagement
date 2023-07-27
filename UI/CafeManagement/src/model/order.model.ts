export interface Order {
    id: string;
    userId: string;
    items: OrderItem[];
    totalAmount: number;
    status: string;
}

export interface OrderItem {
    itemId: string;
    quantity: number;
}

export class Order{
    id!: string;
    userId!: string;
    items!: OrderItem[];
    totalAmount!: number;
    status!: string;
}


export class OrderItem {
    itemId!: string;
    quantity!: number;
}


