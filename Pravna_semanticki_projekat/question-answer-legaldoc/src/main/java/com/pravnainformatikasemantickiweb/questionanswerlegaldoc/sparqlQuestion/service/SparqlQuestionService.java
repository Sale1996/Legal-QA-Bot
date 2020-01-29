package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.service;

import java.util.Collection;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.model.SparqlQuestion;

public interface SparqlQuestionService {

	SparqlQuestion getById(Long id);

    Collection<SparqlQuestion> getAll();

    SparqlQuestion insert(SparqlQuestion sparqlQuestion);

    SparqlQuestion edit(SparqlQuestion sparqlQuestion);

    void delete(Long id);
}
