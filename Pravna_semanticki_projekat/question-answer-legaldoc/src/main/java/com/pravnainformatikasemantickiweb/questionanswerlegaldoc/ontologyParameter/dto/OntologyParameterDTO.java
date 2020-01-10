package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.dto;

import org.springframework.util.Assert;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.dto.OntologyEntityDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.model.OntologyParameter;

import lombok.ToString;


@ToString
public class OntologyParameterDTO {



	private Long parameterId;
	private String parameterName;
	private String parameterSparqlQuery;
	private String parameterType;
	private boolean isMultiConnection;
    private OntologyEntityDTO entity;
    private OntologyEntityDTO connectedEntity;

	
	private OntologyParameterDTO() {
		
	}
	
	public OntologyParameterDTO(String parameterName, String parameterSparqlQuery, String parameterType) {
		Assert.notNull(parameterName, "Parameter name can't be null!");
		Assert.notNull(parameterSparqlQuery,"Sparql query of parameter can't be null!");
		Assert.notNull(parameterType, "Parameter type can't be null!");
		this.parameterName=parameterName;
		this.parameterSparqlQuery = parameterSparqlQuery;
		this.parameterType= parameterType;
	}
	
	public OntologyParameterDTO(String parameterName, String parameterSparqlQuery, String parameterType, boolean isMultiConnection) {
		this(parameterName, parameterSparqlQuery, parameterType);
		Assert.notNull(isMultiConnection, "Multi connection atribute can't be null!");
		this.isMultiConnection = isMultiConnection;
	}
	
	public OntologyParameterDTO(Long id, String parameterName, String parameterSparqlQuery, String parameterType, boolean isMultiConnection) {
		this(parameterName, parameterSparqlQuery, parameterType);
		Assert.notNull(id, "Id property of Ontology Parameter can't be null!");
		this.isMultiConnection = isMultiConnection;
		this.parameterId = id;
	}

	
	
	public OntologyParameterDTO(OntologyParameter bean) {
		this.parameterId = bean.getParameterId();
		this.parameterName = bean.getParameterName();
		this.parameterSparqlQuery = bean.getParameterSparqlQuery();
		this.parameterType = bean.getParameterType();
		this.isMultiConnection = bean.isMultiConnection();
		this.entity = bean.getEntity().asDTO();
		if(bean.getConnectedEntity()!=null)
			this.connectedEntity = bean.getConnectedEntity().asDTO();
	}
	
	
	public OntologyParameter asModel() {
		return new OntologyParameter(this);
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

	public OntologyEntityDTO getEntity() {
		return entity;
	}

	public void setEntity(OntologyEntityDTO entity) {
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

	public OntologyEntityDTO getConnectedEntity() {
		return connectedEntity;
	}

	public void setConnectedEntity(OntologyEntityDTO connectedEntity) {
		this.connectedEntity = connectedEntity;
	}
	
}
