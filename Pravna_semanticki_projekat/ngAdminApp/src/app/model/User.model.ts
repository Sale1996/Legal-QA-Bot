export interface User {
    id : number;
    username : string;
    firstName : string;
    lastName : string;
    email : string;
    roles: Array<string>;
    enabled: boolean;
    deleted: boolean;
    
}