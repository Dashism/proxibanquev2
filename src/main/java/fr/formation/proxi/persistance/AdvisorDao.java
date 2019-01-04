package fr.formation.proxi.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.proxi.metier.entity.Advisor;

@Repository
public interface AdvisorDao extends JpaRepository<Advisor, Integer> {

	/**
	 * Déclaration d'une requête JPQL générée par Spring avec les reste des
	 * méthodes de JpaRepository.
	 * 
	 * @param username le nom recherché.
	 * @return Advisor le conseiller si trouvé sinon null.
	 */
	Advisor findByUsername(String username);
}
