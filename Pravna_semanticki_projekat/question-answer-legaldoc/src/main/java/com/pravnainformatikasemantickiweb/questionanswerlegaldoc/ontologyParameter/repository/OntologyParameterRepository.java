package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.model.OntologyParameter;

public interface OntologyParameterRepository extends JpaRepository<OntologyParameter,Long>  {

	List<OntologyParameter> findAllByEntityEntityId(Long entityId);

}
