package fr.formation.proxi.metier.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.CurrentAccount;
import fr.formation.proxi.metier.entity.SavingsAccount;
import fr.formation.proxi.persistance.ClientDao;

/**
 * Clsse regroupant les traitements � effectuer sur les comptes des clients.
 * Respecte le design pattern singleton.
 * 
 * @author Adminl
 *
 */
@Service
public class AccountService {
	
	@Autowired
	private ClientDao clientDao;
	
	public List<Account> getAll(Integer idClient) {
		List<Account> accounts = new ArrayList<>();

		accounts = this.clientDao.getOne(idClient).getAccounts();

		return accounts;

	}

	public List<Account> getAllSavingAccounts(Integer idClient) {
		List<Account> SavingAccounts = new ArrayList<>();

		List<Account> accounts = new ArrayList<>();
		accounts = this.clientDao.getOne(idClient).getAccounts();

		for (Account account : accounts) {
			if (account instanceof SavingsAccount) {
				SavingAccounts.add(account);
			}
		}
		return SavingAccounts;
	}

	public List<Account> getAllCurrentAccounts(Integer idClient) {
		List<Account> CurrentAccounts = new ArrayList<>();

		List<Account> accounts = new ArrayList<>();
		accounts = this.clientDao.getOne(idClient).getAccounts();

		for (Account account : accounts) {
			if (account instanceof CurrentAccount) {
				CurrentAccounts.add(account);
			}
		}
		return CurrentAccounts;
	}
}
