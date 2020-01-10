package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.dto;

import java.util.List;

public class FindEntityDTO {
	
	private OntologyEntityDTO entity;
	List<FindEntityParameterDTO> parameters;
	
	
	public FindEntityDTO() {
		
	}
	
	
	public FindEntityDTO(OntologyEntityDTO entity, List<FindEntityParameterDTO> parameters) {
		super();
		this.entity = entity;
		this.parameters = parameters;
	}


	public OntologyEntityDTO getEntity() {
		return entity;
	}


	public void setEntity(OntologyEntityDTO entity) {
		this.entity = entity;
	}


	public List<FindEntityParameterDTO> getParameters() {
		return parameters;
	}


	public void setParameters(List<FindEntityParameterDTO> parameters) {
		this.parameters = parameters;
	}

	
	
}
