package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.model.SparqlQuestion;

public interface SparqlQuestionRepository extends JpaRepository<SparqlQuestion, Long> {

	Collection<SparqlQuestion> findAllByLegalEntityLegalEntityId(Long id);

}
