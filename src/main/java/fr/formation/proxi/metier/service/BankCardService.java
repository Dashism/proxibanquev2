package fr.formation.proxi.metier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.proxi.metier.entity.BankCard;
import fr.formation.proxi.persistance.BankCardDao;

@Service
public class BankCardService {

	@Autowired
	private BankCardDao daoCard;

	public BankCard create(String number, String type) {
		return this.daoCard.create(new BankCard(number, type));
	}

	public void delete(Integer id) {
		this.daoCard.delete(id);
	}
}
