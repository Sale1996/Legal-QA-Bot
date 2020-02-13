package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.model.QuestionProperty;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.repository.QuestionPropertyRepository;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.dto.AnswerDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.dto.FindAnswerDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.dto.FindAnswerQuestionParameterDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.exceptions.SparqlQuestionNotFoundException;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.model.SparqlQuestion;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.repository.SparqlQuestionRepository;

@Service
public class SparqlQuestionServiceImpl implements SparqlQuestionService {

	private SparqlQuestionRepository sparqlQuestionRepository;
	private QuestionPropertyRepository questionPropertyRepository;
	
	public SparqlQuestionServiceImpl(SparqlQuestionRepository sparqlQuestionRepository, QuestionPropertyRepository questionPropertyRepository) {
		this.sparqlQuestionRepository = sparqlQuestionRepository;
		this.questionPropertyRepository = questionPropertyRepository;
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
	public Collection<QuestionProperty> getAllPropertiesOfQuestion(Long id) {
		return questionPropertyRepository.findAllBySparqlQuestionSparqlQuestionId(id);
	}


	@Override
	public SparqlQuestion insert(SparqlQuestion sparqlQuestion) {
		return sparqlQuestionRepository.save(sparqlQuestion);
		}

	@Override
	public SparqlQuestion edit(SparqlQuestion sparqlQuestion) {

        Optional<SparqlQuestion> objInDb = sparqlQuestionRepository.findById(sparqlQuestion.getSparqlQuestionId());
        if (objInDb.isPresent()) {
        	objInDb.get().setLegalEntity(sparqlQuestion.getLegalEntity());
        	objInDb.get().setQueryText(sparqlQuestion.getQueryText());
        	objInDb.get().setSparqlQueryText(sparqlQuestion.getSparqlQueryText());
        	
            return sparqlQuestionRepository.save(objInDb.get());

        }

        throw new SparqlQuestionNotFoundException(String.format("Can not PUT sparql question with id: %s because not found", sparqlQuestion.getSparqlQuestionId()));

	}

	@Override
	public void delete(Long id) {
		
        Optional<SparqlQuestion> objInDB = sparqlQuestionRepository.findById(id);

        if (!objInDB.isPresent())
            throw new SparqlQuestionNotFoundException(String.format("Can not DELETE sparql question with id: %s", id));

        sparqlQuestionRepository.deleteById(id);
		
	}


	@Override
	public FindAnswerDTO getFindAnswerParameters(Long id) {
		
		 Optional<SparqlQuestion> sparqlQuestion = sparqlQuestionRepository.findById(id);

         if (!sparqlQuestion.isPresent()) {
            throw new SparqlQuestionNotFoundException(String.format("Can not DELETE sparql question with id: %s", id));
         }
         
         Collection<QuestionProperty> questionProperties = questionPropertyRepository.findAllBySparqlQuestionSparqlQuestionId(id);
         
         FindAnswerDTO newFindAnswerobj = new FindAnswerDTO();
         
         newFindAnswerobj.setQuestion(sparqlQuestion.get().asDTO());
         
         ArrayList<FindAnswerQuestionParameterDTO> questionPropertiesDTO = new ArrayList<FindAnswerQuestionParameterDTO>();
         
         for(QuestionProperty property : questionProperties) {
        	 FindAnswerQuestionParameterDTO parameterOfObject = new FindAnswerQuestionParameterDTO();
        	 parameterOfObject.setQuestionProperty(property.asDTO());
        	 questionPropertiesDTO.add(parameterOfObject);
         }
         
         newFindAnswerobj.setParameters(questionPropertiesDTO);
         
         return newFindAnswerobj;
         
	}


	@Override
	public AnswerDTO getAnswer(@Valid FindAnswerDTO findAnswerDTO) {
		// TODO Auto-generated method stub
		AnswerDTO answer = new AnswerDTO();
		answer.setAnswer("Ovo je odgovor sa backenda");
		return answer;
	}


}
