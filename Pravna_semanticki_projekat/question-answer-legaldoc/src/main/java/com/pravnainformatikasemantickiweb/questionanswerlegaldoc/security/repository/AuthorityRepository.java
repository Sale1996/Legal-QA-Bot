package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{

	Optional<Authority> findOneByName(String role);
	

}
