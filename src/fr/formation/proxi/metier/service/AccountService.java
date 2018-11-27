package fr.formation.proxi.metier.service;

import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.persistance.AccountDao;

/**
 * Clsse regroupant les traitements � effectuer sur les comptes des clients.
 * Respecte le design pattern singleton.
 * 
 * @author Adminl
 *
 */
public class AccountService {

	private static final AccountService INSTANCE = new AccountService();
	private AccountDao dao = new AccountDao();

	/**
	 * Retourne le singleton de la classe.
	 * 
	 * @return Le singleton.
	 */
	public static AccountService getInstance() {
		return AccountService.INSTANCE;
	}

	/**
	 * Recup�re la liste de tous les comptes associ�s � un client.
	 * 
	 * @param idClient L'id du client dont on veut les comptes.
	 * @return La liste des comptes du client.
	 */
	public List<Account> getAll(Integer idClient) {
		List<Account> accounts = new ArrayList<>();

		accounts = this.dao.readAllAccountsForOneClient(idClient);

		return accounts;

	}

	/**
	 * Recup�re la liste des comptes �pargne d'un client.
	 * 
	 * @param idClient L'id du client dont on veut les comptes �pargne.
	 * @return La liste des comptes �pargne du client.
	 */
	public List<Account> getAllSavingAccounts(Integer idClient) {
		List<Account> SavingAccounts = new ArrayList<>();

		List<Account> accounts = new ArrayList<>();
		accounts = this.dao.readAllAccountsForOneClient(idClient);

		for (Account account : accounts) {
			if (account.isSavings()) {
				SavingAccounts.add(account);
			}
		}
		return SavingAccounts;
	}

	/**
	 * Recup�re la liste des comptes courant d'un client.
	 * 
	 * @param idClient L'id du client dont on veut les comptes courant.
	 * @return La liste des comptes courant du client.
	 */
	public List<Account> getAllCurrentAccounts(Integer idClient) {
		List<Account> CurrentAccounts = new ArrayList<>();

		List<Account> accounts = new ArrayList<>();
		accounts = this.dao.readAllAccountsForOneClient(idClient);

		for (Account account : accounts) {
			if (!account.isSavings()) {
				CurrentAccounts.add(account);
			}
		}
		return CurrentAccounts;
	}

	public AccountDao getDao() {
		return this.dao;
	}
}
