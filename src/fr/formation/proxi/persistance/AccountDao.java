package fr.formation.proxi.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Account;

/**
 * Classe permettant les op�rations du C.R.U.D pour les comptes des clients.
 * Respecte le design pattern singleton.
 * 
 * @author Adminl
 *
 */
public class AccountDao implements Dao<Account> {

	private MySqlConnection mySqlConn;

	public AccountDao() {
		this.mySqlConn = MySqlConnection.getInstance();
	}

	/**
	 * R�cup�re un compte en particulier � partir de son id.
	 * 
	 */
	@Override
	public Account read(Integer id) {
		Account account = null;

		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.SELECT_ACCOUNT_BY_ID_ACCOUNT, id));
			while (rs.next()) {
				Integer idAcc = rs.getInt("id");
				String number = rs.getString("number");
				Float balance = rs.getFloat("balance");
				String savingsString = rs.getString("savings");
				Boolean savings = false;
				if (savingsString.equals("1")) {
					savings = true;
				}
				account = new Account(idAcc, number, balance, savings);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public List<Account> readAll() {
		return null;
	}

	/**
	 * Recupere l'ensemble des comptes d'un unique client.
	 * 
	 * @param idClient Le client d'int�r�t.
	 * @return La liste des comptes du client.
	 */
	public List<Account> readAllAccountsForOneClient(Integer idClient) {
		List<Account> accounts = new ArrayList<>();
		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.SELECT_ACCOUNTS_BY_ID, idClient));
			while (rs.next()) {
				Integer idAcc = rs.getInt("id");
				String number = rs.getString("number");
				Float balance = rs.getFloat("balance");
				String savingsString = rs.getString("savings");
				Boolean savings = false;
				if (savingsString.equals("1")) {
					savings = true;
				}
				Account account = new Account(idAcc, number, balance, savings);
				accounts.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	/**
	 * Met � jour les informations d'un compte.
	 *
	 */
	@Override
	public Account update(Account entity) {
		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			st.executeUpdate(
					String.format(SqlQueries.UPDATE_ACCOUNT_BALANCE_BY_ID, entity.getBalance(), entity.getId()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}

}
