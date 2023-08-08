export interface User{
    id: string;
    username: string;
    email: string;
    password: string;
    role: string;
}


export class User{
    id!: string;
    username!: string;
    email!: string;
    password!: string;
    role!: string;
}