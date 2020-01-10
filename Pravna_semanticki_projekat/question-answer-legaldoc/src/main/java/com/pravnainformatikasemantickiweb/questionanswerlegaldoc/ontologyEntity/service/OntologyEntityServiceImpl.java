package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.dto.FindEntityDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.dto.FindEntityParameterDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.dto.OntologyEntityDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.exceptions.OntologyEntityNotFoundException;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.model.OntologyEntity;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.repository.OntologyEntityRepository;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.model.OntologyParameter;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.repository.OntologyParameterRepository;

@Service
public class OntologyEntityServiceImpl implements OntologyEntityService {
	
	private OntologyEntityRepository entityRepository;
	private OntologyParameterRepository parameterRepository;
	
	public OntologyEntityServiceImpl(OntologyEntityRepository repository, OntologyParameterRepository parameterRepository) {
		this.entityRepository = repository;
		this.parameterRepository = parameterRepository;
	}

	@Override
	public OntologyEntity getById(Long id) {
        Optional<OntologyEntity> revVal;

        revVal = entityRepository.findById(id);
        if (!revVal.isPresent())
            throw new OntologyEntityNotFoundException(String.format("Ontology entity with id: %s not found", id));

        return revVal.get();
	}

	@Override
	public Collection<OntologyEntity> getAll() {
	     return entityRepository.findAll();
	}

	@Override
	public OntologyEntity insert(OntologyEntity entity) {
		return entityRepository.save(entity);
	}

	@Override
	public OntologyEntity edit(OntologyEntity entity) {

        Optional<OntologyEntity> objInDb = entityRepository.findById(entity.getEntityId());
        if (objInDb.isPresent())
            return entityRepository.save(entity);

        throw new OntologyEntityNotFoundException(String.format("Can not PUT ontology entity with id: %s because not found", entity.getEntityId()));

	}

	@Override
	public void delete(Long id) {
		
        Optional<OntologyEntity> objInDB = entityRepository.findById(id);

        if (!objInDB.isPresent())
            throw new OntologyEntityNotFoundException(String.format("Can not DELETE ontology entity with id: %s is used in EmpAbsType", id));

        entityRepository.deleteById(id);
		
	}

	@Override
	public FindEntityDTO getProperties(OntologyEntityDTO entity) {
		
	 	FindEntityDTO findEntityDTO = new FindEntityDTO();
	 	findEntityDTO.setEntity(entity);
	 	
	 	List<OntologyParameter> parameters = parameterRepository.findAllByEntityEntityId(entity.getEntityId());

	 	List<FindEntityParameterDTO> listOfFindEntityParameters = new ArrayList<FindEntityParameterDTO>();
	 	
	 	for(OntologyParameter parameter : parameters) {
	 		
	 		FindEntityParameterDTO parameterOfEntity = new FindEntityParameterDTO();
	 		
	 		parameterOfEntity.setParameter(parameter.asDTO());
	 		parameterOfEntity.setWantToFind(false);
	 		parameterOfEntity.setWantToFind(false);
	 		
	 		listOfFindEntityParameters.add(parameterOfEntity);
	 	}
	 	
	 	findEntityDTO.setParameters(listOfFindEntityParameters);
	 	
	 	return findEntityDTO;
	}



}
