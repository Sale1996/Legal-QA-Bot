package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.dto.RegistrationUserDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.dto.UserDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.model.Authority;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.model.User;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.repository.AuthorityRepository;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User findByUsername(String username) throws UsernameNotFoundException {
		User u = userRepository.findByUsername(username);
		return u;
	}

	public User findById(Long id) throws AccessDeniedException {
		Optional<User> u = userRepository.findById(id);
		return u.get();
	}

	public List<User> findAll() throws AccessDeniedException {
		List<User> result = userRepository.findAll();
		return result;
	}

	@Override
	public UserDTO register(@Valid RegistrationUserDTO user) {
		
		Optional<Authority> authority = authorityRepository.findOneByName(user.getRole());
		
		if(!user.getPassword().equals(user.getPassword2()) || !authority.isPresent()) {
			return null; //ovde ce exception
		}
		
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setEnabled(false);
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		
		ArrayList<Authority> authorities = new ArrayList<Authority>();
		authorities.add(authority.get());
		newUser.setAuthorities(authorities);
		
		userRepository.save(newUser);
		
		return newUser.asDTO();
		
	}

	@Override
	public UserDTO updateProfile(@Valid UserDTO user) {

		Optional<User> updateUserOptional = userRepository.findById(user.getId());
		
		if(!updateUserOptional.isPresent()) {
			return null; //tu ce ici exception
		}
		
		User updatedUser = updateUserOptional.get();
		
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setEmail(user.getEmail());
		
		userRepository.save(updatedUser);
		
		return updatedUser.asDTO();
	}

	@Override
	public List<User> findAllLawyers() {
		List<User> result = userRepository.findAllByAuthorities_Name("ROLE_LAWYER");	
		return result;
	}
	
	@Override
	public List<User> findAllAdmins() {
		List<User> result = userRepository.findAllByAuthorities_Name("ROLE_ADMIN");	
		return result;
	}
	
	@Override
	public List<User> findAllSparqlSpecialist() {
		List<User> result = userRepository.findAllByAuthorities_Name("ROLE_SPARQLSPECIALIST");	
		return result;
	}

	@Override
	public UserDTO enableUser(Long userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		
		if(!userOptional.isPresent()) {
			return null; //tu ide exception
		}
		
		userOptional.get().setEnabled(true);
		
		userRepository.save(userOptional.get());
		
		return userOptional.get().asDTO();
	}
}
