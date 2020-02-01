package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.dto.QuestionPropertyDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.model.SparqlQuestion;

@Entity
@Table(name="QuestionProperty")
public class QuestionProperty {

	@Id
	@Column(name="questionPropertyId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long questionPropertyId;
	
	@Column(name="questionPropertyName")
	private String questionPropertyName;
	
	@Column(name="questionPropertyType")
	private String questionPropertyType;
	
	@ManyToOne()
	@JoinColumn (name="sparqlQuestion")
	private SparqlQuestion sparqlQuestion;
	
	
	private QuestionProperty() {
		
	}
	
	public QuestionProperty(String questionPropertyName, String questionPropertyType, SparqlQuestion sparqlQuestion) {
		Assert.notNull(questionPropertyName, "Propertyname can not be null!");
		Assert.notNull(questionPropertyType, "Property type can not be null!");
		Assert.notNull(sparqlQuestion, "Sparql question property can not be null!");
		
		
		this.questionPropertyName= questionPropertyName;
		this.questionPropertyType= questionPropertyType;
		this.sparqlQuestion = sparqlQuestion;
	}
	
	public QuestionProperty(Long id, String questionPropertyName, String questionPropertyType, SparqlQuestion sparqlQuestion) {
		this(questionPropertyName,questionPropertyType, sparqlQuestion);
		
		Assert.notNull(id, "Id field can not be null!");
		this.questionPropertyId = id;
	}
	
	
	public QuestionProperty(QuestionPropertyDTO dto) {
		this.questionPropertyId = dto.getQuestionPropertyId();
		this.questionPropertyName = dto.getQuestionPropertyName();
		this.questionPropertyType = dto.getQuestionPropertyType();
		this.sparqlQuestion = dto.getSparqlQuestion().asModel();
	}

	public QuestionPropertyDTO asDTO() {
		return new QuestionPropertyDTO(this);
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
