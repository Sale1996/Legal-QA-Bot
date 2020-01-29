package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.controller;

import java.util.Collection;
import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.service.QuestionPropertyService;

@RequestMapping("/question-property")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionPropertyController {

	private QuestionPropertyService questionPropertyService;

    public QuestionPropertyController(QuestionPropertyService questionPropertyService) {
        this.questionPropertyService = questionPropertyService;
    }

    @GetMapping
    public ResponseEntity<Collection<QuestionPropertyDTO>> getAll() {
    	
        Collection<QuestionProperty> retVal = questionPropertyService.getAll();
        Collection<QuestionPropertyDTO> retValDTO = new HashSet<>();
        for (QuestionProperty at : retVal) {
            retValDTO.add(at.asDTO());
        }
        return ResponseEntity.accepted().body(retValDTO);
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<QuestionPropertyDTO> getById(@PathVariable Long id) {
        QuestionProperty retVal = questionPropertyService.getById(id);
        return ResponseEntity.accepted().body(retVal.asDTO());
    }


    @PostMapping
    public ResponseEntity<QuestionPropertyDTO> insert(@RequestBody @Valid QuestionPropertyDTO newQuestionProperty) {
        return ResponseEntity.accepted().body(questionPropertyService.insert(newQuestionProperty.asModel()).asDTO());
    }


    @PutMapping
    public ResponseEntity<QuestionPropertyDTO> update(@RequestBody @Valid QuestionPropertyDTO newObj) {
        return ResponseEntity.accepted().body(questionPropertyService.edit(newObj.asModel()).asDTO());
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
    	questionPropertyService.delete(id);
    }
    
}
