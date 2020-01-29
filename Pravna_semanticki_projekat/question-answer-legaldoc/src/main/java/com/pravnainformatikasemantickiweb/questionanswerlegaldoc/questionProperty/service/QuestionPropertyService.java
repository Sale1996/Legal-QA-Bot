package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.service;

import java.util.Collection;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.model.QuestionProperty;

public interface QuestionPropertyService {
	
	QuestionProperty getById(Long id);

    Collection<QuestionProperty> getAll();

    QuestionProperty insert(QuestionProperty questionProperty);

    QuestionProperty edit(QuestionProperty questionProperty);

    void delete(Long id);

}
