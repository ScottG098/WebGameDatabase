package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.GameDetails;
import model.Player;

/**
 * @author Scott Grigsby-sdgrigsby
 *CIS175-Spring 2023
 * Feb 21, 2023
 */
public class PlayerHelper {

	static EntityManagerFactory emfactory= Persistence.createEntityManagerFactory("WebGameDatabase");

	public void insertPLayer(Player p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Player> showAllPlayers() {
		EntityManager em = emfactory.createEntityManager();
		List<Player> allPlayers = em.createQuery("SELECT p FROM Player p").getResultList();
		return allPlayers;
	}
	
	public Player findPlayer(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select pn from Player pn where pn.playerName = :selectedName",Player.class);
	    typedQuery.setParameter("selectedName", nameToLookUp);
	    typedQuery.setMaxResults(1);
	    
	    Player foundPlayer;
	    try {
	    	foundPlayer = typedQuery.getSingleResult();
	    	} catch(NoResultException ex) {
	    		foundPlayer = new Player(nameToLookUp);
	    		}
	    em.close();
	    return foundPlayer;}

	public void deletePlayer(GameDetails toDelete) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<GameDetails> typedQuery = em.createQuery("select detail from GameDetails detail where detail.id = :selectedId", GameDetails.class);
	
		typedQuery.setParameter("selectedId", toDelete.getId());

		typedQuery.setMaxResults(1);
	
		GameDetails result = typedQuery.getSingleResult();
	
		em.remove(result);
		em.getTransaction().commit();
		em.close();
}

	public GameDetails searchForListDetailsById(String tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		GameDetails found = em.find(GameDetails.class, tempId);
		em.close();
		return found;
}}
