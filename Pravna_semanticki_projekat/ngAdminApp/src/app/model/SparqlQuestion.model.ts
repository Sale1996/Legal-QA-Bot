import { LegalEntity } from './LegalEntity.model';

export interface SparqlQuestion{

    sparqlQuestionId : number;
    queryText : string;
    sparqlQueryText: string;
    legalEntity: LegalEntity;
}