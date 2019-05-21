package com.fr.adaming.service;

import java.util.List;

import com.fr.adaming.entity.Equipe;

public interface IEquipeService {
	public String create(Equipe equipe);

	public List<Equipe> readAll();

	public String update(Equipe equipe);

	public boolean delete(Long id);
}
