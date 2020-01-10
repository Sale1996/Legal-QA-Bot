import { OntologyParameter } from './OntologyParameter.model';
import { FindEntity } from './FindEntity.model';

export interface FindEntityParameter{

    parameter : OntologyParameter;
    wantToFind: boolean;
    findParameter: boolean;
    findEntity: FindEntity
    
}