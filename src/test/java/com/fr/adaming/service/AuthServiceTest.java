package com.fr.adaming.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fr.adaming.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthServiceTest {
	
	@Autowired
	private IUserService service;
	
	private static User result;
	
	@Test
	public void a_createUser() {
		User testUser = new User(null, "nom", "prenom", "email@gmail.fr", "pwd12345", null);
		
		String result = service.create(testUser);
		
		assertEquals("un problème d'ajout d'un user", "SUCCESS", result);
		
	}
	
	public void b_delete() {
		boolean resultat = service.delete(result.getId());
		
		assertTrue(resultat);
	}
	
	@Before //pour initialiser des method
	public void beforeClass() {
		System.out.println("BEFORE ANY METHOD START");
	}
	
	@After
	public void aftereClass() {
		System.out.println("AFTER ANY METHOD END");
	}
}
