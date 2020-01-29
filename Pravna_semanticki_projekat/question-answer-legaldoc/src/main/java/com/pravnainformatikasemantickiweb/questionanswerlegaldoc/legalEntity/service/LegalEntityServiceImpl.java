package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.exceptions.LegalEntityNotFoundException;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.model.LegalEntity;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.repository.LegalEntityRepository;

@Service
public class LegalEntityServiceImpl implements LegalEntityService {

	private LegalEntityRepository legalEntityRepository;
	
	public LegalEntityServiceImpl(LegalEntityRepository legalEntityRepository) {
		this.legalEntityRepository = legalEntityRepository;
	}
	
	
	@Override
	public LegalEntity getById(Long id) {
        Optional<LegalEntity> revVal;

        revVal = legalEntityRepository.findById(id);
        if (!revVal.isPresent())
            throw new LegalEntityNotFoundException(String.format("Legal entity with id: %s not found", id));

        return revVal.get();
	}

	@Override
	public Collection<LegalEntity> getAll() {
	     return legalEntityRepository.findAll();
	 	}

	@Override
	public LegalEntity insert(LegalEntity entity) {
		return legalEntityRepository.save(entity);
		}

	@Override
	public LegalEntity edit(LegalEntity entity) {

        Optional<LegalEntity> objInDb = legalEntityRepository.findById(entity.getLegalEntityId());
        if (objInDb.isPresent())
            return legalEntityRepository.save(entity);

        throw new LegalEntityNotFoundException(String.format("Can not PUT legal entity with id: %s because not found", entity.getLegalEntityId()));

	}

	@Override
	public void delete(Long id) {
		
        Optional<LegalEntity> objInDB = legalEntityRepository.findById(id);

        if (!objInDB.isPresent())
            throw new LegalEntityNotFoundException(String.format("Can not DELETE legal entity with id: %s", id));

        legalEntityRepository.deleteById(id);
		
	}

}
