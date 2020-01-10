import { OntologyEntity } from './OntologyEntity.model';
import { FindEntityParameter } from './FindEntityParameter.model';

export interface FindEntity{
    
	entity: OntologyEntity;
	parameters: Array<FindEntityParameter> ;
    
}