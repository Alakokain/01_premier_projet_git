package com.fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.entity.User;
import com.fr.adaming.service.IUserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "api")
public class UserRestController {

	@Autowired
	private IUserService service;
	
	//ApiOperation met des notes avec swagger Value est la ref, notes le détail
	//Créer un DTO pour retirer l'id et permettre de simplifier le travail du front end
	@ApiOperation(notes = "Id doit être null ou moins nul", value = "Create")
	@RequestMapping(path = "/users", method = RequestMethod.POST)
	public void create(@RequestBody User user) {
		service.create(user);
	}

	@RequestMapping(path = "/users/{emailParam}", method = RequestMethod.GET)
	public User readByEmail(@PathVariable(name = "emailParam") String email) {
		return service.readByEmail(email);
	}

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<User> readAll() {
		return service.readAll();
	}

	@RequestMapping(path = "/users", method = RequestMethod.PUT)
	public void update(@RequestBody User user) {
		service.update(user);
	}

	@RequestMapping(path = "/users/{idUser}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(name = "idUser") Long id) {
		service.delete(id);
	}
}
