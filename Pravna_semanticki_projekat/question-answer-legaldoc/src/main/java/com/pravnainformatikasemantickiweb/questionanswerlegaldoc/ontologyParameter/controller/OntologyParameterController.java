package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.controller;

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

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.dto.OntologyParameterDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.model.OntologyParameter;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.service.OntologyParameterService;

@RequestMapping("/ontology-parameter")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OntologyParameterController {

	private OntologyParameterService ontologyParameterService;

    public OntologyParameterController(OntologyParameterService ontologyParameterService) {
        this.ontologyParameterService = ontologyParameterService;
    }

    @GetMapping
    public ResponseEntity<Collection<OntologyParameterDTO>> getAll() {
    	
        Collection<OntologyParameter> retVal = ontologyParameterService.getAll();
        Collection<OntologyParameterDTO> retValDTO = new HashSet<>();
        for (OntologyParameter at : retVal) {
            retValDTO.add(at.asDTO());
        }
        return ResponseEntity.accepted().body(retValDTO);
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<OntologyParameterDTO> getById(@PathVariable Long id) {
        OntologyParameter retVal = ontologyParameterService.getById(id);
        return ResponseEntity.accepted().body(retVal.asDTO());
    }


    @PostMapping
    public ResponseEntity<OntologyParameterDTO> insert(@RequestBody @Valid OntologyParameterDTO newOntologyParameter) {
        return ResponseEntity.accepted().body(ontologyParameterService.insert(newOntologyParameter.asModel()).asDTO());
    }


    @PutMapping
    public ResponseEntity<OntologyParameterDTO> update(@RequestBody @Valid OntologyParameterDTO newObj) {
        return ResponseEntity.accepted().body(ontologyParameterService.edit(newObj.asModel()).asDTO());
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        ontologyParameterService.delete(id);
    }
}
