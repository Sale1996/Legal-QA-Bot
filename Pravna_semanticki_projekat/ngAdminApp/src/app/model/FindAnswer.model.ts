import { SparqlQuestion } from './SparqlQuestion.model';
import { FindAnswerQuestionParameter } from './FindAnswerQuestionParameter.model';

export interface FindAnswer{

    question : SparqlQuestion;
    parameters: Array<FindAnswerQuestionParameter>;

}