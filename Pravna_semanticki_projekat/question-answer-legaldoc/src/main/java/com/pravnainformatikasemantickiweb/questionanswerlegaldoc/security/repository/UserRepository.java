package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername( String username );

	List<User> findAllByAuthorities_Name(String string);
}

