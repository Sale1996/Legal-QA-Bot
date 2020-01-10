package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.util.Assert;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.model.OntologyEntity;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.dto.OntologyParameterDTO;

@Entity
@Table(name ="OntologyParameter")
public class OntologyParameter {
	
	@Id
	@Column(name = "ontologyParameterId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long parameterId;
	
	@Column(name="ontologyParameterName")
	private String parameterName;
	
	@Column(name="ontologyParameterSparqlQuery")
	private String parameterSparqlQuery;
	
	@Column(name="parameterType")
	private String parameterType;
	
	@Column(name="isMultiConnection")
	private boolean isMultiConnection;
	
    @ManyToOne ()
	@JoinColumn (name="entity",nullable = false)
    private OntologyEntity entity;
    
    @ManyToOne ()
	@JoinColumn (name="connectedEntity")
    private OntologyEntity connectedEntity;
	
	
	private OntologyParameter() {
		
	}
	
	public OntologyParameter(String parameterName, String parameterSparqlQuery, String parameterType) {
		Assert.notNull(parameterName, "Parameter name can't be null!");
		Assert.notNull(parameterSparqlQuery,"Sparql query of parameter can't be null!");
		Assert.notNull(parameterType, "Parameter type can't be null!");
		this.parameterName=parameterName;
		this.parameterSparqlQuery = parameterSparqlQuery;
		this.parameterType= parameterType;
	}
	
	public OntologyParameter(String parameterName, String parameterSparqlQuery, String parameterType, boolean isMultiConnection) {
		this(parameterName, parameterSparqlQuery, parameterType);
		Assert.notNull(isMultiConnection, "Multi connection atribute can't be null!");
		this.isMultiConnection = isMultiConnection;
	}
	
	public OntologyParameter(Long id, String parameterName, String parameterSparqlQuery, String parameterType, boolean isMultiConnection) {
		this(parameterName, parameterSparqlQuery, parameterType);
		Assert.notNull(id, "Id property of Ontology Parameter can't be null!");
		this.isMultiConnection = isMultiConnection;
		this.parameterId = id;
	}

	
	
	public OntologyParameter(OntologyParameterDTO dto) {
		this.parameterId = dto.getParameterId();
		this.parameterName = dto.getParameterName();
		this.parameterSparqlQuery = dto.getParameterSparqlQuery();
		this.parameterType = dto.getParameterType();
		this.isMultiConnection = dto.isMultiConnection();
		this.entity = dto.getEntity().asModel();
		if(dto.getConnectedEntity()!=null)
			this.connectedEntity = dto.getConnectedEntity().asModel();
	}
	
	
	public OntologyParameterDTO asDTO() {
		return new OntologyParameterDTO(this);
	}
	
	public Long getParameterId() {
		return parameterId;
	}

	public void setParameterId(Long parameterId) {
		this.parameterId = parameterId;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterSparqlQuery() {
		return parameterSparqlQuery;
	}

	public void setParameterSparqlQuery(String parameterSparqlQuery) {
		this.parameterSparqlQuery = parameterSparqlQuery;
	}

	public OntologyEntity getEntity() {
		return entity;
	}

	public void setEntity(OntologyEntity entity) {
		this.entity = entity;
	}

	public String getParameterType() {
		return parameterType;
	}

	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}

	public boolean isMultiConnection() {
		return isMultiConnection;
	}

	public void setMultiConnection(boolean isMultiConnection) {
		this.isMultiConnection = isMultiConnection;
	}

	public OntologyEntity getConnectedEntity() {
		return connectedEntity;
	}

	public void setConnectedEntity(OntologyEntity connectedEntity) {
		this.connectedEntity = connectedEntity;
	}

	
}
