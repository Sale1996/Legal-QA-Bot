package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.dto.UserDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.model.User;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.service.UserService;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;

	
	@RequestMapping(method = GET, value = "/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public User loadById(@PathVariable Long userId) {
		return this.userService.findById(userId);
	}

	@RequestMapping(method = GET, value = "/all")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> loadAll() {
		return this.userService.findAll();
	}
	
	@GetMapping("/getLawyers")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> getLawyers(){
		return this.userService.findAllLawyers();
	}
	
	@GetMapping("/getAdmins")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> getAdmins(){
		return this.userService.findAllAdmins();
	}
	
	@GetMapping("/getSparqlSpecialists")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> getSparqlSpecialist(){
		return this.userService.findAllSparqlSpecialist();
	}
	
    @PutMapping
	@PreAuthorize("hasAnyRole('LAWYER','SPARQLSPECIALIST')")
    public ResponseEntity<UserDTO> updateProfile(@RequestBody @Valid UserDTO user) {
        return ResponseEntity.accepted().body(userService.updateProfile(user));
    }
    
    @PutMapping("/enableUser/")
	@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDTO> enableProfile(@RequestBody Long userId) {
        return ResponseEntity.accepted().body(userService.enableUser(userId));
    }
    
    @PutMapping("/restoreUser/")
	@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDTO> restoreUser(@RequestBody Long userId) {
        return ResponseEntity.accepted().body(userService.restoreUser(userId));
    }
    
    @DeleteMapping("/{id}")
  	@PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
      	userService.delete(id);
    }

	@RequestMapping("/whoami")
	@PreAuthorize("hasAnyRole('LAWYER','ADMIN','SPARQLSPECIALIST')")
	public UserDTO user(Principal user) {
		return this.userService.findByUsername(user.getName()).asDTO();
	}
}
