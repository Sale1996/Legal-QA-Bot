package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.service;

import java.util.List;

import javax.validation.Valid;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.dto.RegistrationUserDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.dto.UserDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.model.User;


public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
	UserDTO register(@Valid RegistrationUserDTO newUser);
	UserDTO updateProfile(@Valid UserDTO user);
	List<User> findAllLawyers();
	List<User> findAllAdmins();
	List<User> findAllSparqlSpecialist();
	UserDTO enableUser(Long userId);
	void delete(Long id);

}
