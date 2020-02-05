package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.service;

import java.util.List;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.model.User;


public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
}
