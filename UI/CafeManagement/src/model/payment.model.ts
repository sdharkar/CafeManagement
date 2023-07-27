export interface Payment{
    id: string;
    orderId: String;
    amount: number;
    status: string;
}

export class Payment{
    id!: string;
    orderId!: String;
    amount!: number;
    status!: string;
}