package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.dto;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.dto.OntologyParameterDTO;

public class FindEntityParameterDTO {
	
	private OntologyParameterDTO parameter;
	private boolean  wantToFind;
	private boolean findParameter;
	private FindEntityDTO findEntity; //if there is need for advanced search
	
	
	public FindEntityParameterDTO() {}
	
	public FindEntityParameterDTO(OntologyParameterDTO parameter, boolean wantToFind, boolean findParameter,
			FindEntityDTO findEntity) {
		super();
		this.parameter = parameter;
		this.wantToFind = wantToFind;
		this.findParameter = findParameter;
		this.findEntity = findEntity;
	}

	public OntologyParameterDTO getParameter() {
		return parameter;
	}

	public void setParameter(OntologyParameterDTO parameter) {
		this.parameter = parameter;
	}

	public boolean isWantToFind() {
		return wantToFind;
	}

	public void setWantToFind(boolean wantToFind) {
		this.wantToFind = wantToFind;
	}

	public boolean isFindParameter() {
		return findParameter;
	}

	public void setFindParameter(boolean findParameter) {
		this.findParameter = findParameter;
	}

	public FindEntityDTO getFindEntity() {
		return findEntity;
	}

	public void setFindEntity(FindEntityDTO findEntity) {
		this.findEntity = findEntity;
	}

}
