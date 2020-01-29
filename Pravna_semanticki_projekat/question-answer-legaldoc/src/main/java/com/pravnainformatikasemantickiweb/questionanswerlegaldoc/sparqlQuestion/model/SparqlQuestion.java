package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.model.LegalEntity;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.model.QuestionProperty;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.dto.SparqlQuestionDTO;

@Entity
@Table(name="SparqlQuestion")
public class SparqlQuestion{
	
	@Id
	@Column(name="sparqlQuestionId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long sparqlQuestionId;
	
	@Column(name="queryText")
	private String queryText;
	
	@Column(name="sparqlQueryText")
	private String sparqlQueryText;
	
	@ManyToOne ()
	@JoinColumn (name="legalEntity",nullable = false)
    private LegalEntity legalEntity;
	
	@OneToMany (mappedBy="sparqlQuestion")
	private List<QuestionProperty> parameters;

	
	private SparqlQuestion() {
		
	}
	
	public SparqlQuestion(String queryText, String sparqlQueryText) {
		Assert.notNull(queryText, "Query text can not be null!");
		Assert.notNull(sparqlQueryText, "Sparql query text can not be null");
		
		this.queryText = queryText;
		this.sparqlQueryText = sparqlQueryText;
	}
	
	public SparqlQuestion(String queryText, String sparqlQueryText, LegalEntity legalEntity) {
		this(queryText, sparqlQueryText);
		Assert.notNull(legalEntity, "Legal entity field can not be null!");
	
		this.legalEntity = legalEntity;
	}
	
	public SparqlQuestion(Long id, String queryText, String sparqlQueryText, LegalEntity legalEntity) {
		this(queryText, sparqlQueryText, legalEntity);
		Assert.notNull(id, "Id field can not be null!");
		
		this.sparqlQuestionId = id;
	}
	
	public SparqlQuestion(SparqlQuestionDTO dto) {
		this.sparqlQuestionId = dto.getSparqlQuestionId();
		this.queryText = dto.getQueryText();
		this.sparqlQueryText = dto.getSparqlQueryText();
		this.legalEntity = dto.getLegalEntity();
	}
		
	public SparqlQuestionDTO asDTO() {
		return new SparqlQuestionDTO(this);
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

	public LegalEntity getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(LegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}

	public List<QuestionProperty> getParameters() {
		return parameters;
	}

	public void setParameters(List<QuestionProperty> parameters) {
		this.parameters = parameters;
	}
	
	
	
	
}
