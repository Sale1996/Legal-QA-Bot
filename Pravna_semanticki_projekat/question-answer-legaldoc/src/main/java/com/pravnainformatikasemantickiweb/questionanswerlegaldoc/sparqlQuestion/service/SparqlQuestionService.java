package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.service;

import java.util.Collection;

import javax.validation.Valid;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.dto.FindAnswerDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.model.SparqlQuestion;

public interface SparqlQuestionService {

	SparqlQuestion getById(Long id);

    Collection<SparqlQuestion> getAll();

    SparqlQuestion insert(SparqlQuestion sparqlQuestion);

    SparqlQuestion edit(SparqlQuestion sparqlQuestion);

    void delete(Long id);

	FindAnswerDTO getFindAnswerParameters(Long id);

	Object getAnswer(@Valid FindAnswerDTO findAnswerDTO);
}
