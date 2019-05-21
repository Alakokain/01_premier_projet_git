package com.fr.adaming.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IUserDao;
import com.fr.adaming.entity.User;

@Service
public class UserService implements IUserService {
	// On peut qualifier un bean de spring mais ce n'est pas utile
	@Autowired
	private IUserDao dao;

	Logger log = Logger.getLogger(UserService.class);

	@Override
	public String create(User user) {
		if ((user != null && user.getId() == null) || (user != null && user.getId() == 0)) {
			try {
				dao.save(user);
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

			// System.out.println("DEBUG CREATE : USER CREATED WITHOUT ID");
			// La methode peut générer des problèmes CONTRAINTE EMAIL, NULL POINTER
			log.info("USER CREATED WITHOUT ID");
			return "SUCCESS";
		} else if (user != null) {
			if (dao.existsById(user.getId())) {
				log.info("DEBUG CREATE : PAS DE CREATION L'UTILISATEUR EXISTE DEJA");
				// throw new Exception();
				return "FAIL";
			} else {
				try {
					dao.save(user);
					// System.out.println("DEBUG CREATE : USER CREATED");
					log.info("USER CREATED");

					return "SUCCESS";
				} catch (Exception e) {
					if (e instanceof SQLIntegrityConstraintViolationException) {
						log.info(e.getStackTrace());
					}

					return "FAIL";
				}
			}

		} else if (user == null) {
			log.info("USER NULL");
		}
		return "FAIL";
	}

	@Override
	public User readByEmail(String email) {
		User res = null;
		try {
			res = dao.findByEmail(email);
		} catch (Exception e) {
			if (e instanceof IllegalArgumentException) {
				log.error(e.getStackTrace());
			} else {
				log.error(e.getStackTrace());
			}

		}
		return res;
	}

	@Override
	public String update(User user) {
		if (user.getId() == null) {
			// System.out.println("DEBUG UPDATE : ERREUR L'UTILISATEUR N'A PAS D'ID");
			log.info("ERREUR L'UTILISATEUR N'A PAS D'ID");
		} else {
			try {
				if (dao.existsById(user.getId())) {
					try {
						dao.save(user);
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
					// System.out.println("DEBUG UPDATE : L'UTILISATEUR N'EXISTE PAS");
					log.info("L'UTILISATEUR N'EXISTE PAS");
					return "FAIL";
				}
			} catch (Exception e) {
				if (e instanceof IllegalArgumentException) {
					log.error(e.getStackTrace());
				} else {
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
			if (e instanceof IllegalArgumentException) {
				log.error(e.getStackTrace());
			} else {
				e.printStackTrace();
				log.error(e.getStackTrace());
			}
		}
		return false;
	}

	@Override
	public List<User> readAll() {
		return dao.findAll();
	}
}
