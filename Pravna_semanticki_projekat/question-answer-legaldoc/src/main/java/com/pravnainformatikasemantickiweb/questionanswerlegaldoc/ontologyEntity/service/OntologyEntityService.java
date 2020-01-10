package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.service;

import java.util.Collection;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.dto.FindEntityDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.dto.OntologyEntityDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.model.OntologyEntity;

public interface OntologyEntityService {
	
	OntologyEntity getById(Long id);

    Collection<OntologyEntity> getAll();

    OntologyEntity insert(OntologyEntity entity);

    OntologyEntity edit(OntologyEntity entity);

    void delete(Long id);

	FindEntityDTO getProperties(OntologyEntityDTO entity);

}
