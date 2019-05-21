package com.fr.adaming.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fr.adaming.entity.User;

@Repository
public interface IAuthDao extends JpaRepository<User, Long>{

	User findByEmailAndPwd(String email, String pwd);

}
