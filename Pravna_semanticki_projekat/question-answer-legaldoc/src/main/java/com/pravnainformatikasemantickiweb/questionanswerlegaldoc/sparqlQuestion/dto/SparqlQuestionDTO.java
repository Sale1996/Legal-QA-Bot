package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.dto;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.dto.LegalEntityDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.model.LegalEntity;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.model.SparqlQuestion;

import lombok.ToString;

@ToString
public class SparqlQuestionDTO {

	private Long sparqlQuestionId;
	private String queryText;
	private String sparqlQueryText;
    private LegalEntityDTO legalEntity;

    
    public SparqlQuestionDTO() {
    	
    }
    
    public SparqlQuestionDTO(SparqlQuestion bean) {
    	this.sparqlQuestionId = bean.getSparqlQuestionId();
    	this.queryText = bean.getQueryText();
    	this.sparqlQueryText = bean.getSparqlQueryText();
    	this.legalEntity = bean.getLegalEntity().asDTO();
    }
    
    public SparqlQuestion asModel() {
    	return new SparqlQuestion(this);
    }

	public Long getSparqlQuestionId() {
		return sparqlQuestionId;
	}

	public void setSparqlQuestionId(Long sparqlQuestionId) {
		this.sparqlQuestionId = sparqlQuestionId;
	}

	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}

	public String getSparqlQueryText() {
		return sparqlQueryText;
	}

	public void setSparqlQueryText(String sparqlQueryText) {
		this.sparqlQueryText = sparqlQueryText;
	}

	public LegalEntityDTO getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(LegalEntityDTO legalEntity) {
		this.legalEntity = legalEntity;
	}
    
    
}
