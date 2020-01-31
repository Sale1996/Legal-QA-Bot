import { QuestionProperty } from './QuestionProperty.model';
import { LegalEntity } from './LegalEntity.model';

export interface FindAnswerQuestionParameter{

    questionProperty : QuestionProperty;
    textInput: string;
    numberInput: number;
    booleanInput: boolean;
    selectedEntity: LegalEntity;

}