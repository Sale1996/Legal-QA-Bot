package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername( String username );
}

