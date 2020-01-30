package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.dto;

import java.util.Collection;

import lombok.ToString;

@ToString
public class FindAnswerDTO {

	private SparqlQuestionDTO question;
	private Collection<FindAnswerQuestionParameterDTO> parameters;
	
	public FindAnswerDTO() {
		
	}

	public SparqlQuestionDTO getQuestion() {
		return question;
	}

	public void setQuestion(SparqlQuestionDTO question) {
		this.question = question;
	}

	public Collection<FindAnswerQuestionParameterDTO> getParameters() {
		return parameters;
	}

	public void setParameters(Collection<FindAnswerQuestionParameterDTO> parameters) {
		this.parameters = parameters;
	}
	
	
}
