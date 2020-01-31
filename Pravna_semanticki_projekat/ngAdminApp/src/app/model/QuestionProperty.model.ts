import { SparqlQuestion } from './SparqlQuestion.model';

export interface QuestionProperty{

    questionPropertyId : number;
    questionPropertyName: string;
    questionPropertyType: string;
    sparqlQuestion : SparqlQuestion;
}