import { OntologyParameter } from './OntologyParameter.model';
import { FindEntity } from './FindEntity.model';
import { OntologyEntity } from './OntologyEntity.model';

export interface FindEntityParameter{

    parameter : OntologyParameter;
    wantToFind: boolean;
    findParameter: boolean;
    findEntity: FindEntity;
    textInput: string;
    numberInput: number;
    booleanInput: boolean;
    connectedEntityInput: OntologyEntity;
    
}