package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.dto;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.dto.OntologyParameterDTO;

public class FindEntityParameterDTO {
	
	private OntologyParameterDTO parameter;
	private boolean  wantToFind;
	private boolean findParameter;
	private FindEntityDTO findEntity; //if there is need for advanced search
	private String textInput;
	private int numberInput;
	private boolean booleanInput;
	private OntologyEntityDTO connectedEntityInput;
	
	
	public FindEntityParameterDTO() {}
	
	public FindEntityParameterDTO(OntologyParameterDTO parameter, boolean wantToFind, boolean findParameter,
			FindEntityDTO findEntity, String textInput, int numberInput, boolean booleanInput, OntologyEntityDTO connectedEntityInput) {
		super();
		this.parameter = parameter;
		this.wantToFind = wantToFind;
		this.findParameter = findParameter;
		this.findEntity = findEntity;
		this.textInput = textInput;
		this.numberInput = numberInput;
		this.booleanInput = booleanInput;
		this.connectedEntityInput = connectedEntityInput;
		
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

	public String getTextInput() {
		return textInput;
	}

	public void setTextInput(String textInput) {
		this.textInput = textInput;
	}

	public int getNumberInput() {
		return numberInput;
	}

	public void setNumberInput(int numberInput) {
		this.numberInput = numberInput;
	}

	public boolean isBooleanInput() {
		return booleanInput;
	}

	public void setBooleanInput(boolean booleanInput) {
		this.booleanInput = booleanInput;
	}

	public OntologyEntityDTO getConnectedEntityInput() {
		return connectedEntityInput;
	}

	public void setConnectedEntityInput(OntologyEntityDTO connectedEntityInput) {
		this.connectedEntityInput = connectedEntityInput;
	}

}
