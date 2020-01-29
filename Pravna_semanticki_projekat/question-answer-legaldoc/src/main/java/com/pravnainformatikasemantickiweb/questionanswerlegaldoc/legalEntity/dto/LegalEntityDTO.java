package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.dto;


import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.model.LegalEntity;

import lombok.ToString;

@ToString
public class LegalEntityDTO {

	private Long legalEntityId;
	private String legalEntityName;
	
	
	public LegalEntityDTO() {
		
	}
	
	public LegalEntityDTO(LegalEntity bean) {
		this.legalEntityId = bean.getLegalEntityId();
		this.legalEntityName = bean.getLegalEntityName();
	}
	
	public LegalEntity asModel() {
		return new LegalEntity(this);
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
