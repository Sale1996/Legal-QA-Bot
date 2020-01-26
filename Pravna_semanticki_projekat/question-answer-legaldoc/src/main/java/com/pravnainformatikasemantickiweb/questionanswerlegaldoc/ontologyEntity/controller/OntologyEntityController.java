package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.controller;

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

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.dto.FindEntityDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.dto.OntologyEntityDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.model.OntologyEntity;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.service.OntologyEntityService;

@RequestMapping("/ontology-entity")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OntologyEntityController {

	private OntologyEntityService ontologyEntityService;

    public OntologyEntityController(OntologyEntityService ontologyEntityService) {
        this.ontologyEntityService = ontologyEntityService;
    }

    @GetMapping
    public ResponseEntity<Collection<OntologyEntityDTO>> getAll() {
    	
        Collection<OntologyEntity> retVal = ontologyEntityService.getAll();
        Collection<OntologyEntityDTO> retValDTO = new HashSet<>();
        for (OntologyEntity at : retVal) {
            retValDTO.add(at.asDTO());
        }
        return ResponseEntity.accepted().body(retValDTO);
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<OntologyEntityDTO> getById(@PathVariable Long id) {
        OntologyEntity retVal = ontologyEntityService.getById(id);
        return ResponseEntity.accepted().body(retVal.asDTO());
    }


    @PostMapping
    public ResponseEntity<OntologyEntityDTO> insert(@RequestBody @Valid OntologyEntityDTO newOntologyEntity) {
        return ResponseEntity.accepted().body(ontologyEntityService.insert(newOntologyEntity.asModel()).asDTO());
    }


    @PutMapping
    public ResponseEntity<OntologyEntityDTO> update(@RequestBody @Valid OntologyEntityDTO newObj) {
        return ResponseEntity.accepted().body(ontologyEntityService.edit(newObj.asModel()).asDTO());
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        ontologyEntityService.delete(id);
    }
    
    
    @PostMapping("/getProperties")
    public ResponseEntity<FindEntityDTO> getProperties(@RequestBody OntologyEntityDTO entity){
    	return ResponseEntity.accepted().body(ontologyEntityService.getProperties(entity));
    }
}
