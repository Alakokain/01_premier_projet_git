package com.fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.entity.Equipe;
import com.fr.adaming.service.IEquipeService;

@RestController
@RequestMapping(path = "api")
public class EquipeRestController {
	
	@Autowired
	private IEquipeService service;
	
	//Avec create on utilise la method POST
	@RequestMapping(path = "/equipe", method=RequestMethod.POST)
	public void create(@RequestBody Equipe equipe) {
		service.create(equipe);
	}
	
	//Avec READ on utilise la method GET
	@RequestMapping(path = "/equipe", method=RequestMethod.GET)
	public List<Equipe> readAll() {
		return service.readAll();
	}
	
	//Avec update on utilise la method PUT
	@RequestMapping(path = "/equipe", method=RequestMethod.PUT)
	public void update(@RequestBody Equipe equipe) {
		service.update(equipe);
	}
	
	//Avec delete on utilise la method DELETE
	@RequestMapping(path = "/equipe/{idEquipe}", method=RequestMethod.DELETE)
	public void delete(@PathVariable(name= "idEquipe")Long id) {
		service.delete(id);
	}
	
	
	
}
