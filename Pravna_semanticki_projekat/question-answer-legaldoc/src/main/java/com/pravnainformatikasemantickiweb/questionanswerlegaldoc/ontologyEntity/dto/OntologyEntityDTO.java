package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.dto;


import org.springframework.util.Assert;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.model.OntologyEntity;

import lombok.ToString;


@ToString
public class OntologyEntityDTO {
	
	private Long entityId;
	private String entityName;
	private String entitySparqlQuery;
	
	
	private OntologyEntityDTO() {
		
	}
	
	public OntologyEntityDTO(String entityName, String sparqlQuery) {
		Assert.notNull(entityName, "Entity name can't be null!");
		Assert.notNull(sparqlQuery,"Sparql query of entty can't be null!");
		this.entityName=entityName;
		this.entitySparqlQuery = sparqlQuery;
	}
	
	
	public OntologyEntityDTO(Long id, String entityName, String sparqlQuery) {
		this(entityName, sparqlQuery);
		Assert.notNull(id, "Id property of Ontology Entity can't be null!");
		this.entityId = id;
	}
	
	
	public OntologyEntityDTO(OntologyEntity bean) {
		this.entityId = bean.getEntityId();
		this.entityName = bean.getEntityName();
		this.entitySparqlQuery = bean.getEntitySparqlQuery();
	}
	
	
	public OntologyEntity asModel() {
		return new OntologyEntity(this);
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
	
}
