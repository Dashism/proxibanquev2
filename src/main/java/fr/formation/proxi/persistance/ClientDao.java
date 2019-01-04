package fr.formation.proxi.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.proxi.metier.entity.Client;

@Repository
public interface ClientDao extends JpaRepository<Client, Integer> {

	Client findByCard_Number(String number);
}
