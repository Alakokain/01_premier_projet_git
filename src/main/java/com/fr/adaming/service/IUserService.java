package com.fr.adaming.service;

import java.util.List;

import com.fr.adaming.entity.User;

public interface IUserService {
	
	public String create(User user);
	
	public List<User> readAll();
	
	public User readByEmail(String email);
	
	public String update(User user);
	
	public boolean delete(Long id);
}
