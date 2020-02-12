export interface User {
    id : number;
    username : string;
    firstName : string;
    lastName : string;
    email : string;
    role: Array<string>;
    enabled: boolean;
    deleted: boolean;
    
}