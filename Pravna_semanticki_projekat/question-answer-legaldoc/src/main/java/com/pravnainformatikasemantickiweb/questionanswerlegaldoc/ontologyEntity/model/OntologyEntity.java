package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.dto.OntologyEntityDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.model.OntologyParameter;

@Entity
@Table(name="OntologyEntity")
public class OntologyEntity {

	@Id
	@Column(name="ontologyEntityId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long entityId;
	
	@Column(name="ontologyEntityName")
	private String entityName;
	
	@Column(name="ontologyEntitySparqlQuery")
	private String entitySparqlQuery;
	
	@OneToMany (mappedBy="entity")
	private List<OntologyParameter> parameters;

	@OneToMany (mappedBy="connectedEntity")
	private List<OntologyParameter> connectedParameters;
	
	private OntologyEntity() {
		
	}
	
	public OntologyEntity(String entityName, String sparqlQuery) {
		Assert.notNull(entityName, "Entity name can't be null!");
		Assert.notNull(sparqlQuery,"Sparql query of entty can't be null!");
		this.entityName=entityName;
		this.entitySparqlQuery = sparqlQuery;
	}
	
	
	public OntologyEntity(Long id, String entityName, String sparqlQuery) {
		this(entityName, sparqlQuery);
		Assert.notNull(id, "Id property of Ontology Entity can't be null!");
		this.entityId = id;
	}
	
	
	public OntologyEntity(OntologyEntityDTO dto) {
		this.entityId = dto.getEntityId();
		this.entityName = dto.getEntityName();
		this.entitySparqlQuery = dto.getEntitySparqlQuery();
	}
	
	
	public OntologyEntityDTO asDTO() {
		return new OntologyEntityDTO(this);
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEntitySparqlQuery() {
		return entitySparqlQuery;
	}

	public void setEntitySparqlQuery(String entitySparqlQuery) {
		this.entitySparqlQuery = entitySparqlQuery;
	}

	public List<OntologyParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<OntologyParameter> parameters) {
		this.parameters = parameters;
	}
	
	
}
