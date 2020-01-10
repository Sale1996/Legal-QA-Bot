package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.service;

import java.util.Collection;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.model.OntologyParameter;


public interface OntologyParameterService {
	
	OntologyParameter getById(Long id);

    Collection<OntologyParameter> getAll();

    OntologyParameter insert(OntologyParameter parameter);

    OntologyParameter edit(OntologyParameter parameter);

    void delete(Long id);

}
