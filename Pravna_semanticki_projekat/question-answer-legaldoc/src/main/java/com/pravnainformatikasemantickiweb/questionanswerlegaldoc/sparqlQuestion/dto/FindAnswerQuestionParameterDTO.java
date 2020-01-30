package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.dto;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.dto.LegalEntityDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.dto.QuestionPropertyDTO;

import lombok.ToString;

@ToString
public class FindAnswerQuestionParameterDTO {

	private QuestionPropertyDTO questionProperty;
	private String textInput;
	private int numberInput;
	private boolean booleanInput;
	private LegalEntityDTO selectedEntity;
	
	public FindAnswerQuestionParameterDTO() {
		
	}

	public QuestionPropertyDTO getQuestionProperty() {
		return questionProperty;
	}

	public void setQuestionProperty(QuestionPropertyDTO questionProperty) {
		this.questionProperty = questionProperty;
	}

	public String getTextInput() {
		return textInput;
	}

	public void setTextInput(String textInput) {
		this.textInput = textInput;
	}

	public int getNumberInput() {
		return numberInput;
	}

	public void setNumberInput(int numberInput) {
		this.numberInput = numberInput;
	}

	public boolean isBooleanInput() {
		return booleanInput;
	}

	public void setBooleanInput(boolean booleanInput) {
		this.booleanInput = booleanInput;
	}

	public LegalEntityDTO getSelectedEntity() {
		return selectedEntity;
	}

	public void setSelectedEntity(LegalEntityDTO selectedEntity) {
		this.selectedEntity = selectedEntity;
	}
	
	
}
