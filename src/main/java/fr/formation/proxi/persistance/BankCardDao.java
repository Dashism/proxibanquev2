package fr.formation.proxi.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.proxi.metier.entity.BankCard;

@Repository
public interface BankCardDao extends JpaRepository<BankCard, Integer> {

}
