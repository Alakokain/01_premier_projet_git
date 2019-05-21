package com.fr.adaming.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fr.adaming.entity.User;

@Repository
public interface IUserDao extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
