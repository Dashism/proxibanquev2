package fr.formation.proxi.metier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.persistance.AccountDao;
import fr.formation.proxi.persistance.ClientDao;

/**
 * Clsse regroupant les traitements � effectuer sur les clients. Respecte le
 * design pattern singleton.
 * 
 * @author Adminl
 *
 */
@Service
public class ClientService {

	@Autowired
	private ClientDao daoClient;
	
	@Autowired
	private AccountDao daoAccount;

	public List<Client> getAll() {
		return this.daoClient.findAll();
	}

	public boolean transfer(Float value, Integer debitId, Integer creditId,
			Integer clientId) {
		boolean transferOK = true;
		Client client = this.daoClient.getOne(clientId);
		Account compteDebite = client.getAccountById(debitId);
		Account compteCredite = client.getAccountById(creditId);
		if (compteDebite.getId() == compteCredite.getId()) {
			return transferOK;
		} else if (compteDebite.getBalance() - value < 0) {
			transferOK = false;
			return transferOK;
		} else {
			compteCredite.setBalance(compteCredite.getBalance() + value);
			this.daoAccount.save(compteCredite);

			compteDebite.setBalance(compteDebite.getBalance() - value);
			this.daoAccount.save(compteDebite);

			return transferOK;
		}
	}

	public Client read(Integer id) {
		return this.daoClient.getOne(id);
	}

	public void update(Client client) {
		this.daoClient.save(client);
	}

	public void setDaoClient(ClientDao daoClient) {
		this.daoClient = daoClient;
	}

	public void setDaoAccount(AccountDao daoAccount) {
		this.daoAccount = daoAccount;
	}

}
