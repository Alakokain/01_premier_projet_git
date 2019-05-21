package com.fr.adaming.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IEquipeDao;
import com.fr.adaming.entity.Equipe;

@Service
public class EquipeService implements IEquipeService {
	
	@Autowired
	private IEquipeDao dao;
	
	Logger log = Logger.getLogger(UserService.class);
	
	@Override
	public String create(Equipe equipe) {
		if ((equipe != null && equipe.getId() == null) || (equipe != null && equipe.getId() == 0)) {
			dao.save(equipe);
			//System.out.println("DEBUG EQUIPE :EQUIPE CREATED WITHOUT ID");
			log.info("CREATE EQUIPE WITHOUT ID");
			return "SUCCESS";
		} else {
			try {
				if (dao.existsById(equipe.getId())) {
					log.warn("DEBUG CREATE : PAS DE CREATION EQUIPE EXISTE DEJA");
					return "FAIL";
				} else {
					dao.save(equipe);
					//System.out.println("DEBUG CREATE : USER CREATED");
					log.info("EQUIPE CREATED");
					return "SUCCESS";
				}
			} catch (Exception e) {
				if(e instanceof IllegalArgumentException) {
					log.error(e.getStackTrace());
				}else {
					log.error(e.getStackTrace());
				}
			}
		}
		return "FAIL";
	}

	@Override
	public List<Equipe> readAll() {
		return dao.findAll();
	}

	@Override
	public String update(Equipe equipe) {
		if (equipe.getId() == null && equipe != null) {
			//System.out.println("DEBUG UPDATE : ERREUR L'UTILISATEUR N'A PAS D'ID");
			log.error("ERREUR L'EQUIPE N'A PAS D'ID");
			return "FAIL";
		} else {
			try {
				if (dao.existsById(equipe.getId())) {
					try {
						dao.save(equipe);
						log.info("UTILISATEUR MODIFIÉ");
						return "SUCCESS";
					} catch (Exception e) {
						// LES CATCH SQL sont constant et donc en info
						if (e instanceof SQLIntegrityConstraintViolationException) {
							log.info(e.getStackTrace());
						} else {
							// LES ERREUR inconnue doivent être reconnue et log
							log.error(e.getStackTrace());
						}

						return "FAIL";
					}
				} else {
					//System.out.println("DEBUG UPDATE : L'UTILISATEUR N'EXISTE PAS");
					log.info("L'EQUIPE N'EXISTE PAS");
				}
			} catch (Exception e) {
				if(e instanceof IllegalArgumentException) {
					log.info(e.getStackTrace());
				}else {
					log.error(e.getStackTrace());
				}
			}
		}
		return "FAIL";
	}

	@Override
	public boolean delete(Long id) {
		try {
			dao.deleteById(id);
			return true;
		} catch (Exception e) {
			if(e instanceof IllegalArgumentException) {
				log.error(e.getStackTrace());
			}else {
				log.error(e.getStackTrace());
			}
		}
		return false;
	}

}
