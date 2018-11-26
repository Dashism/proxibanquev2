package fr.formation.proxi.persistance;

import java.util.List;

/**
 * D�finition d'une interface comportant les 4 m�thodes �l�mentaires de 
 * manipulation de donn�es CRUD 
 * + readALL.
 * @param <T> classe qui repr�sente le type de donn�es manipul� par le DAO.
 */
public interface Dao<T> {
	
	

	
	
	
	
	/**
	 * Lit lesinformations d'une entit� de BDD
	 * 
	 * @param id l'identifiant d'une entit� en base de donn�es
	 * @return T l'entit� construite � partir des informations r�cup�r�es
	 * 
	 */
	public T read(Integer id);
	
	
	
	
	/**
	 * R�cup�re toutes les entit�s (lignes) d'une table
	 * 
	 * @return List<T> la liste de toutes les entit�s lues.
	 */
	public List<T> readAll();
	
	
	
	/**
	 * met � jour l'entit� donn� dans la BDD
	 *  
	 * @param entity l'entit� � mettre � jour avec les nouvelles informations
	 * @return l'entit� mise � jour
	 */
	public T update(T entity);
	
	
	
	
	
}
