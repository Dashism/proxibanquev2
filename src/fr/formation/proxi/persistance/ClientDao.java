package fr.formation.proxi.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Client;

/**
 * Classe regroupant les traitements � effectuer sur les clients. Respecte le
 * design pattern singleton.
 * 
 * @author Adminl
 *
 */
public class ClientDao implements Dao<Client> {

	private MySqlConnection mySqlConn;

	public ClientDao() {
		this.mySqlConn = MySqlConnection.getInstance();
	}

	/**
	 * Permet de r�cup�rer les informations d'un client � partir de son id.
	 * 
	 */
	@Override
	public Client read(Integer id) {

		Client client = null;

		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.SELECT_CLIENT_BY_ID, id));
			while (rs.next()) {
				Integer idcli = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String address = rs.getString("address");
				client = new Client(firstname, lastname, email, address);
				client.setId(idcli);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}

	/**
	 * R�cup�re l'ensemble des clients enregistr�s dans la Base De Donn�es.
	 * 
	 */
	@Override
	public List<Client> readAll() {
		List<Client> clients = new ArrayList<>();
		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(SqlQueries.SELECT_ALL_CLIENTS);
			while (rs.next()) {
				Integer idcli = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String address = rs.getString("address");
				Client client = new Client(firstname, lastname, email, address);
				client.setId(idcli);
				clients.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clients;
	}

	/**
	 * Met � jour les informations d'un client sp�cifique. G�re la modification du
	 * nom, du pr�nom, de l'email et de l'adresse du client.
	 * 
	 */
	@Override
	public Client update(Client entity) {

		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			st.executeUpdate(String.format(SqlQueries.UPDATE_CLIENT, entity.getLastname(), entity.getFirstname(),
					entity.getEmail(), entity.getAddress(), entity.getId()));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}

}
