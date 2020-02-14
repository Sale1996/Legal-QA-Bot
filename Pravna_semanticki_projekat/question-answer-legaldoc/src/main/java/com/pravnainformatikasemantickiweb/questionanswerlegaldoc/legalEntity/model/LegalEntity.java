package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.dto.LegalEntityDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.model.SparqlQuestion;

@Entity
@Table(name="LegalEntity")
public class LegalEntity {
	
	@Id
	@Column(name="legalEntityId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long legalEntityId;
	
	@Column(name="legalEntityName")
	private String legalEntityName;
	
	@OneToMany (mappedBy="legalEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SparqlQuestion> sparqlQuestions;

	
	private LegalEntity() {	
	}
	
	public LegalEntity(String legalEntityName) {
		Assert.notNull(legalEntityName, "Legal entity name field can't be nulll");
		this.legalEntityName=legalEntityName;
	}
	
	public LegalEntity(String legalEntityName, Long id) {
		this(legalEntityName);
		Assert.notNull(id,"Id can't be null!");
		this.legalEntityId=id;
	}
	
	public LegalEntity(LegalEntityDTO dto) {
		this.legalEntityId = dto.getLegalEntityId();
		this.legalEntityName = dto.getLegalEntityName();
	}
	
	public LegalEntityDTO asDTO() {
		return new LegalEntityDTO(this);
	}
	
	
	
	

	public Long getLegalEntityId() {
		return legalEntityId;
	}

	public void setLegalEntityId(Long legalEntityId) {
		this.legalEntityId = legalEntityId;
	}

	public String getLegalEntityName() {
		return legalEntityName;
	}

	public void setLegalEntityName(String legalEntityName) {
		this.legalEntityName = legalEntityName;
	}
	
	
	
}
