package com.fr.adaming.service;

import java.sql.SQLIntegrityConstraintViolationException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IAuthDao;
import com.fr.adaming.entity.User;

@Service
public class AuthService implements IAuthService{
	
	@Autowired
	private IAuthDao dao;
	
	Logger log = Logger.getLogger(UserService.class);
	
	@Override
	public User login(String email, String pwd) {
		return dao.findByEmailAndPwd(email, pwd);
	}


	@Override
	public String register(User user) {
		try {
			dao.save(user);
			return "SUCCESS";
		} catch (Exception e) {
			if(e instanceof SQLIntegrityConstraintViolationException) {
				log.info(e.getStackTrace());
			}else {
				log.error(e.getStackTrace());
			}
		}
		return "FAIL";
	}

}
