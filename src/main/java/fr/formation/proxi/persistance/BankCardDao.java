package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import fr.formation.proxi.metier.entity.BankCard;

@Component
public class BankCardDao extends AbstractDao<BankCard> {
	
	private static final BankCardDao INSTANCE = new BankCardDao();

	public static BankCardDao getInstance() {
		return BankCardDao.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BankCard read(Integer id) {
		return this.read(id, new BankCard());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BankCard> readAll() {
		List<BankCard> cards = new ArrayList<>();
		TypedQuery<BankCard> query = this.em
				.createQuery(JpqlQueries.SELECT_ALL_BANKCARD, BankCard.class);
		cards.addAll(query.getResultList());
		return cards;
	}

}
