package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.controller;

import java.util.Collection;
import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.dto.QuestionPropertyDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.model.QuestionProperty;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.dto.AnswerDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.dto.FindAnswerDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.dto.SparqlQuestionDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.model.SparqlQuestion;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.service.SparqlQuestionService;

@RequestMapping("/sparql-question")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SparqlQuestionController {

	private SparqlQuestionService sparqlQuestionService;

    public SparqlQuestionController(SparqlQuestionService sparqlQuestionService) {
        this.sparqlQuestionService = sparqlQuestionService;
    }

    @GetMapping
    public ResponseEntity<Collection<SparqlQuestionDTO>> getAll() {
    	
        Collection<SparqlQuestion> retVal = sparqlQuestionService.getAll();
        Collection<SparqlQuestionDTO> retValDTO = new HashSet<>();
        for (SparqlQuestion at : retVal) {
            retValDTO.add(at.asDTO());
        }
        return ResponseEntity.accepted().body(retValDTO);
    }
    
    @GetMapping("/available")
    public ResponseEntity<Collection<SparqlQuestionDTO>> getAllAvailable() {
    	
        Collection<SparqlQuestion> retVal = sparqlQuestionService.getAllAvailable();
        Collection<SparqlQuestionDTO> retValDTO = new HashSet<>();
        for (SparqlQuestion at : retVal) {
            retValDTO.add(at.asDTO());
        }
        return ResponseEntity.accepted().body(retValDTO);
    }
    
    @GetMapping("/properties/{id}")
    public ResponseEntity<Collection<QuestionPropertyDTO>> getAllPropertiesOfQuestion(@PathVariable Long id) {
    	
        Collection<QuestionProperty> retVal = sparqlQuestionService.getAllPropertiesOfQuestion(id);
        Collection<QuestionPropertyDTO> retValDTO = new HashSet<>();
        for (QuestionProperty at : retVal) {
            retValDTO.add(at.asDTO());
        }
        return ResponseEntity.accepted().body(retValDTO);
    }
    
    
    
    @GetMapping("/findAnswerParameters/{id}")
    public ResponseEntity<FindAnswerDTO> getAllParametersFindAnswer(@PathVariable Long id){
    	
    	FindAnswerDTO newAnswerObject = sparqlQuestionService.getFindAnswerParameters(id);
    	
    	return ResponseEntity.accepted().body(newAnswerObject);
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<SparqlQuestionDTO> getById(@PathVariable Long id) {
        SparqlQuestion retVal = sparqlQuestionService.getById(id);
        return ResponseEntity.accepted().body(retVal.asDTO());
    }
    
    @PostMapping("/getAnswer")
    public ResponseEntity<AnswerDTO> getAnswer(@RequestBody FindAnswerDTO findAnswerDTO) {
        return ResponseEntity.accepted().body(sparqlQuestionService.getAnswer(findAnswerDTO));
    }


    @PostMapping
	@PreAuthorize("hasRole('LAWYER')")
    public ResponseEntity<SparqlQuestionDTO> insert(@RequestBody @Valid SparqlQuestionDTO newSparqlQuestion) {
        return ResponseEntity.accepted().body(sparqlQuestionService.insert(newSparqlQuestion.asModel()).asDTO());
    }


    @PutMapping
	@PreAuthorize("hasAnyRole('LAWYER','SPARQLSPECIALIST')")
    public ResponseEntity<SparqlQuestionDTO> update(@RequestBody @Valid SparqlQuestionDTO newObj) {
        return ResponseEntity.accepted().body(sparqlQuestionService.edit(newObj.asModel()).asDTO());
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
	@PreAuthorize("hasRole('LAWYER')")
    public void delete(@PathVariable Long id) {
    	sparqlQuestionService.delete(id);
    }
    
}
