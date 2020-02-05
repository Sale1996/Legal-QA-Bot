package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.controller;

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

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.dto.LegalEntityDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.model.LegalEntity;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.service.LegalEntityService;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.dto.SparqlQuestionDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.model.SparqlQuestion;

@RequestMapping("/legal-entity")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LegalEntityController {

	private LegalEntityService legalEntityService;
	
	public LegalEntityController(LegalEntityService legalEntityService) {
		this.legalEntityService = legalEntityService;
	}
	
	@GetMapping
    public ResponseEntity<Collection<LegalEntityDTO>> getAll() {
    	
        Collection<LegalEntity> retVal = legalEntityService.getAll();
        Collection<LegalEntityDTO> retValDTO = new HashSet<>();
        for (LegalEntity at : retVal) {
            retValDTO.add(at.asDTO());
        }
        return ResponseEntity.accepted().body(retValDTO);
    }
	
	@GetMapping("/questions/{id}")
	public ResponseEntity<Collection<SparqlQuestionDTO>> getAllQuestionsOfLegalEntity(@PathVariable Long id){
		
        Collection<SparqlQuestion> retVal = legalEntityService.getAllQuestionsOfLegalEntity(id);
        Collection<SparqlQuestionDTO> retValDTO = new HashSet<>();
        for (SparqlQuestion at : retVal) {
            retValDTO.add(at.asDTO());
        }
        return ResponseEntity.accepted().body(retValDTO);
	}

  
    @GetMapping("/{id}")
    public ResponseEntity<LegalEntityDTO> getById(@PathVariable Long id) {
        LegalEntity retVal = legalEntityService.getById(id);
        return ResponseEntity.accepted().body(retVal.asDTO());
    }


    @PostMapping
	@PreAuthorize("hasRole('LAWYER')")
    public ResponseEntity<LegalEntityDTO> insert(@RequestBody @Valid LegalEntityDTO newLegalEntity) {
        return ResponseEntity.accepted().body(legalEntityService.insert(newLegalEntity.asModel()).asDTO());
    }


    @PutMapping
	@PreAuthorize("hasRole('LAWYER')")
    public ResponseEntity<LegalEntityDTO> update(@RequestBody @Valid LegalEntityDTO newObj) {
        return ResponseEntity.accepted().body(legalEntityService.edit(newObj.asModel()).asDTO());
    }


    @DeleteMapping("/{id}")
	@PreAuthorize("hasRole('LAWYER')")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
    	legalEntityService.delete(id);
    }
    
}
