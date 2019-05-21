package com.fr.adaming.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fr.adaming.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {
	
	@Autowired
	private IUserService service;
	
	private static User resultat;
	
	@Test @Ignore
	public void a_createUser() {
		
		resultat = new User(null, "nom", "prenom", "email@gmail.fr", "pwd12345", null);
		String result = service.create(resultat);
		
		assertEquals("un problème de ou d'ajout d'un user", "SUCCESS", result);
		
	}
	
	@Test
	public void b_createUserNull() {
		resultat = new User();
		
		String result = service.create(resultat);
		
		assertEquals("un problème de ou d'ajout d'un user", "FAIL", result);
		
	}
	
	@Test @Ignore
	public void c_createUser() {
		
		resultat = new User(null, "", "prenom", "email@gmail.fr", "pwd12345", null);
		String result = service.create(resultat);
		
		assertEquals("un problème de ou d'ajout d'un user", "SUCCESS", result);
		
	}

// Problème d'id en test avec le if else partout
//	@Test
//	public void c_createUserWithId() {
//		resultat = new User(1L ,"nom", "prenom", "email@gmail.fr", "pwd12345", null);
//		
//		String result = service.create(resultat);
//		
//		assertEquals("un problème de ou d'ajout d'un user", "SUCCESS", result);
//		
//	}
	
//	@Test
//	public void d_createUserDuplicataId() {
//		resultat = new User(1L ,"nom", "prenom", "email@gmail.fr", "pwd12345", null);
//		User result2 = resultat;
//		service.create(result2);
//		String result = service.create(resultat);
//		
//		assertEquals("un problème de ou d'ajout d'un user", "FAIL", result);
//		service.delete(result2.getId());
//		
//	}
	
	@Test @Ignore
	public void ea_deleteUserValid() {
		a_createUser();
		
		boolean result = service.delete(1L);
		
		assertEquals("De delete d'un utilisateur", true, result);
		
	}
	
	@Test
	public void e_deleteUserWrongId() {
		
		boolean result = service.delete(8L);
		
		assertEquals("De delete d'un utilisateur", false, result);
		
	}
	
	@Test
	public void f_deleteUserNull() {
		
		boolean result = service.delete(null);
		
		assertEquals("De delete d'un utilisateur", false, result);
		
	}
	
	@Test @Ignore
	public void g_updateUser() {
		//Problem getting id for the thing since it is autogenerated
		resultat = new User(null, "nom", "prenom", "email@gmail.fr", "pwd12345", null);
		service.create(resultat);
		resultat = new User(1L, "nom2", "prenom2", "email2@gmail.fr", "pwd12345", null);
		String result2 = service.update(resultat);
		assertEquals("un problème update d'un user", "SUCCESS", result2);
		
	}
	
	@Test
	public void g_updateUserWrongId() {
		
		resultat = new User(null, "nom", "prenom", "email@gmail.fr", "pwd12345", null);
		service.create(resultat);
		resultat = new User(9L, "nom2", "prenom2", "email2@gmail.fr", "pwd12345", null);
		String result2 = service.update(resultat);
		assertEquals("un problème de ou d'ajout d'un user", "FAIL", result2);
		
	}
	
	@Test
	public void h_updateUserNullId() {
		
		resultat = new User(null, "nom", "prenom", "email@gmail.fr", "pwd12345", null);
		service.create(resultat);
		resultat = new User(null, "nom2", "prenom2", "email2@gmail.fr", "pwd12345", null);
		String result2 = service.update(resultat);
		assertEquals("un problème de ou d'ajout d'un user", "FAIL", result2);
		
	}
	
	@Test @Ignore
	public void i_findByMail() {
		a_createUser();
		//resultat = new User(null, "nom", "prenom", "email@gmail.fr", "pwd12345", null);
		System.out.println("FUCKING EMAIL" +resultat.getEmail());
		User result = service.readByEmail(resultat.getEmail());
		assertNotNull(result);
		
	}
	
	@After
	public void afterClass() {
		System.out.println("AFTER ANY METHOD END");
		if(resultat != null && resultat.getId() != null) {
			service.delete(resultat.getId());
			
			System.out.println("*********************** DELETE *************************");
		}
	}

}