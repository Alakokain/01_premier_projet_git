package com.fr.adaming;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fr.adaming.entity.Equipe;
import com.fr.adaming.entity.User;
import com.fr.adaming.service.IEquipeService;
import com.fr.adaming.service.IUserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
public class EquipeProjectApplication {
	

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EquipeProjectApplication.class, args);
//		List<User> listUser = new ArrayList<User>();
//
//		User u = new User(1L, "nom", "prenom", "email", "pwd");
//		listUser.add(u); 
//
//		Equipe e = new Equipe(1L, "FC Nantes", "Football", listUser);
//		
//		IUserService service = (IUserService) context.getBean("userService");
//		IEquipeService eqservice = (IEquipeService) context.getBean("equipeService");
//		service.create(u);
//		eqservice.create(e);
		Logger log = Logger.getLogger(EquipeProjectApplication.class);
//		log.trace("message");
//		log.fatal("message");
	}

}
