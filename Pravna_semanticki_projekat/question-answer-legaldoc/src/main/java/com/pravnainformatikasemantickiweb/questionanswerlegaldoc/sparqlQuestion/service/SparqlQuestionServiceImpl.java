package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.exceptions.SparqlQuestionNotFoundException;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.model.SparqlQuestion;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.repository.SparqlQuestionRepository;

@Service
public class SparqlQuestionServiceImpl implements SparqlQuestionService {

	private SparqlQuestionRepository sparqlQuestionRepository;
	
	public SparqlQuestionServiceImpl(SparqlQuestionRepository sparqlQuestionRepository) {
		this.sparqlQuestionRepository = sparqlQuestionRepository;
	}
	
	
	@Override
	public SparqlQuestion getById(Long id) {
        Optional<SparqlQuestion> revVal;

        revVal = sparqlQuestionRepository.findById(id);
        if (!revVal.isPresent())
            throw new SparqlQuestionNotFoundException(String.format("Sparql Question with id: %s not found", id));

        return revVal.get();
	}

	@Override
	public Collection<SparqlQuestion> getAll() {
	     return sparqlQuestionRepository.findAll();
	 }

	@Override
	public SparqlQuestion insert(SparqlQuestion sparqlQuestion) {
		return sparqlQuestionRepository.save(sparqlQuestion);
		}

	@Override
	public SparqlQuestion edit(SparqlQuestion sparqlQuestion) {

        Optional<SparqlQuestion> objInDb = sparqlQuestionRepository.findById(sparqlQuestion.getSparqlQuestionId());
        if (objInDb.isPresent())
            return sparqlQuestionRepository.save(sparqlQuestion);

        throw new SparqlQuestionNotFoundException(String.format("Can not PUT sparql question with id: %s because not found", sparqlQuestion.getSparqlQuestionId()));

	}

	@Override
	public void delete(Long id) {
		
        Optional<SparqlQuestion> objInDB = sparqlQuestionRepository.findById(id);

        if (!objInDB.isPresent())
            throw new SparqlQuestionNotFoundException(String.format("Can not DELETE sparql question with id: %s", id));

        sparqlQuestionRepository.deleteById(id);
		
	}

}
