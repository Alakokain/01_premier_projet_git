package com.fr.adaming.service;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fr.adaming.entity.Equipe;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EquipeServiceTest {
	@Autowired
	private IEquipeService service;
	
	private static Equipe resultat;
	
	@Test @Ignore
	public void a_createEquipe() {
		
		resultat = new Equipe(null, "nomEquipe", "sport");
		String result = service.create(resultat);
		
		assertEquals("un problème de ou d'ajout d'un user", "SUCCESS", result);
		
	}
	
	@Test @Ignore
	public void b_createEquipeNull() {
		resultat = new Equipe();
		
		String result = service.create(resultat);
		
		assertEquals("un problème de ou d'ajout d'un user", "FAIL", result);
		
	}
	
	@Test @Ignore
	public void c_createEquipe() {
		
		resultat = new Equipe(null, "nomEquipe", "sport");
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
	public void e_deleteEquipeWrongId() {
		
		boolean result = service.delete(8L);
		
		assertEquals("De delete d'un utilisateur", false, result);
		
	}
	
	@Test @Ignore
	public void f_deleteUserNull() {
		
		boolean result = service.delete(null);
		
		assertEquals("De delete d'un utilisateur", false, result);
		
	}
	
	@Test
	public void g_updateEquipe() {
		
		resultat = new Equipe(null, "nomEquipe", "sport");
		service.create(resultat);
		resultat = new Equipe(1L, "nomEquipe2", "sport2");
		String result2 = service.update(resultat);
		assertEquals("un problème de ou d'ajout d'un user", "SUCCESS", result2);
		
	}
	
	@Test @Ignore
	public void g_updateUserWrongId() {
		
		resultat = new Equipe(null, "nomEquipe", "sport");
		service.create(resultat);
		resultat = new Equipe(9L, "nomEquipe2", "sport2");
		String result2 = service.update(resultat);
		assertEquals("un problème de ou d'ajout d'un user", "FAIL", result2);
		
	}
	
	@Test @Ignore
	public void h_updateUserNullId() {
		
		resultat = new Equipe(null, "nomEquipe", "sport");
		service.create(resultat);
		resultat = new Equipe(null, "nomEquipe2", "sport2");
		String result2 = service.update(resultat);
		assertEquals("un problème de ou d'ajout d'un user", "FAIL", result2);
		
	}
	
	@After
	public void afterClass() {
		System.out.println("AFTER ANY METHOD END");
		if(resultat != null) {
			service.delete(resultat.getId());
			
			System.out.println("*********************** DELETE *************************");
		}
	}
}
