package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.model.QuestionProperty;

public interface QuestionPropertyRepository extends JpaRepository<QuestionProperty, Long> {

	Collection<QuestionProperty> findAllBySparqlQuestionSparqlQuestionId(Long id);

}
