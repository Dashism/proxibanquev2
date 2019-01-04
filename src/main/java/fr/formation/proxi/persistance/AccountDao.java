package fr.formation.proxi.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.proxi.metier.entity.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {

}
