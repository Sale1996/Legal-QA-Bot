package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.dto;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.model.QuestionProperty;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.model.SparqlQuestion;

import lombok.ToString;

@ToString
public class QuestionPropertyDTO {
	
	private Long questionPropertyId;
	private String questionPropertyName;
	private String questionPropertyType;
	private SparqlQuestion sparqlQuestion;
	
	
	public QuestionPropertyDTO() {
		
	}
	
	public QuestionPropertyDTO(QuestionProperty bean) {
		this.questionPropertyId = bean.getQuestionPropertyId();
		this.questionPropertyName = bean.getQuestionPropertyName();
		this.questionPropertyType = bean.getQuestionPropertyType();
		this.sparqlQuestion = bean.getSparqlQuestion();
	}
	
	public QuestionProperty asModel() {
		return new QuestionProperty(this);
	}

	public Long getQuestionPropertyId() {
		return questionPropertyId;
	}

	public void setQuestionPropertyId(Long questionPropertyId) {
		this.questionPropertyId = questionPropertyId;
	}

	public String getQuestionPropertyName() {
		return questionPropertyName;
	}

	public void setQuestionPropertyName(String questionPropertyName) {
		this.questionPropertyName = questionPropertyName;
	}

	public String getQuestionPropertyType() {
		return questionPropertyType;
	}

	public void setQuestionPropertyType(String questionPropertyType) {
		this.questionPropertyType = questionPropertyType;
	}

	public SparqlQuestion getSparqlQuestion() {
		return sparqlQuestion;
	}

	public void setSparqlQuestion(SparqlQuestion sparqlQuestion) {
		this.sparqlQuestion = sparqlQuestion;
	}

}
