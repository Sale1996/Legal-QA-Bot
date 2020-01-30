package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.service;

import java.util.Collection;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.model.LegalEntity;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.model.SparqlQuestion;

public interface LegalEntityService {
	
		LegalEntity getById(Long id);

	    Collection<LegalEntity> getAll();

	    LegalEntity insert(LegalEntity entity);

	    LegalEntity edit(LegalEntity entity);

	    void delete(Long id);

		Collection<SparqlQuestion> getAllQuestionsOfLegalEntity(Long id);

}
