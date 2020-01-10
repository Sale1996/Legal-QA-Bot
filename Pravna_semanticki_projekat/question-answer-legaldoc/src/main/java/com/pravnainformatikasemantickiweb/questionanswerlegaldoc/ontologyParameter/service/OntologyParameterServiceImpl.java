package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.exceptions.OntologyParameterNotFoundException;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.model.OntologyParameter;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.repository.OntologyParameterRepository;


@Service
public class OntologyParameterServiceImpl implements OntologyParameterService {
	
	private OntologyParameterRepository parameterRepository;
	
	public OntologyParameterServiceImpl(OntologyParameterRepository repository) {
		this.parameterRepository = repository;
	}

	@Override
	public OntologyParameter getById(Long id) {
        Optional<OntologyParameter> revVal;

        revVal = parameterRepository.findById(id);
        if (!revVal.isPresent())
            throw new OntologyParameterNotFoundException(String.format("Ontology parameter with id: %s not found", id));

        return revVal.get();
	}

	@Override
	public Collection<OntologyParameter> getAll() {
	     return parameterRepository.findAll();
	}

	@Override
	public OntologyParameter insert(OntologyParameter parameter) {
		return parameterRepository.save(parameter);
	}

	@Override
	public OntologyParameter edit(OntologyParameter parameter) {

        Optional<OntologyParameter> objInDb = parameterRepository.findById(parameter.getParameterId());
        if (objInDb.isPresent())
            return parameterRepository.save(parameter);

        throw new OntologyParameterNotFoundException(String.format("Can not PUT ontology parameter with id: %s because not found", parameter.getParameterId()));

	}

	@Override
	public void delete(Long id) {
		
        Optional<OntologyParameter> objInDB = parameterRepository.findById(id);

        if (!objInDB.isPresent())
            throw new OntologyParameterNotFoundException(String.format("Can not DELETE parameter entity with id: %s is used in EmpAbsType", id));

        parameterRepository.deleteById(id);
		
	}

}
