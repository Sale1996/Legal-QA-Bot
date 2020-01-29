package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.exceptions.QuestionPropertyNotFoundException;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.model.QuestionProperty;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.repository.QuestionPropertyRepository;

@Service
public class QuestionPropertyServiceImpl implements QuestionPropertyService{

	private QuestionPropertyRepository questionPropertyRepository;
	
	public QuestionPropertyServiceImpl(QuestionPropertyRepository questionPropertyRepository) {
		this.questionPropertyRepository = questionPropertyRepository;
	}
	
	
	
	@Override
	public QuestionProperty getById(Long id) {
        Optional<QuestionProperty> revVal;

        revVal = questionPropertyRepository.findById(id);
        if (!revVal.isPresent())
            throw new QuestionPropertyNotFoundException(String.format("Question property with id: %s not found", id));

        return revVal.get();
	}

	@Override
	public Collection<QuestionProperty> getAll() {
	     return questionPropertyRepository.findAll();
	 }

	@Override
	public QuestionProperty insert(QuestionProperty questionProperty) {
		return questionPropertyRepository.save(questionProperty);
	}

	@Override
	public QuestionProperty edit(QuestionProperty questionProperty) {

        Optional<QuestionProperty> objInDb = questionPropertyRepository.findById(questionProperty.getQuestionPropertyId());
        if (objInDb.isPresent())
            return questionPropertyRepository.save(questionProperty);

        throw new QuestionPropertyNotFoundException(String.format("Can not PUT question property with id: %s because not found", questionProperty.getQuestionPropertyId()));

	}

	@Override
	public void delete(Long id) {
		
        Optional<QuestionProperty> objInDB = questionPropertyRepository.findById(id);

        if (!objInDB.isPresent())
            throw new QuestionPropertyNotFoundException(String.format("Can not DELETE question property with id: %s", id));

        questionPropertyRepository.deleteById(id);
		
	}

}
