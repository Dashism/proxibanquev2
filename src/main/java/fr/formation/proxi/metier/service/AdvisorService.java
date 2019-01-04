package fr.formation.proxi.metier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.proxi.metier.entity.Advisor;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.persistance.AdvisorDao;

@Service
public class AdvisorService {

	@Autowired
	private AdvisorDao daoAdvisor;

	/**
	 * Méthode à implémenter.
	 * 
	 * @param id l'identifiant du conseiller pour lequel chercher les clients.
	 * @return List<Client> la liste des clients du conseiller demandé.
	 */
	public List<Client> getClientsByAdvisorId(Integer id) {
		Advisor advisor = this.daoAdvisor.getOne(id);
		return advisor.getClients();
	}

	/**
	 * Méthode passe-plat pour rechercher un conseiller par son nom.
	 * 
	 * @param username le nom d'utilisateur (login) du conseiller.
	 * @return Integer l'identifiant du conseiller trouvée.
	 */
	public Integer getAdvisorIdByName(String username) {
		return this.daoAdvisor.findByUsername(username).getId();
	}
}
