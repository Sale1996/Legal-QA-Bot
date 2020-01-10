import { OntologyEntity } from './OntologyEntity.model';

export interface OntologyParameter{
    
    parameterId: number;
    parameterName: string;
    parameterSparqlQuery: string; 
    parameterType: string;
    isMultiConnection: boolean;
    entity: OntologyEntity;
    connectedEntity: OntologyEntity;
    
}