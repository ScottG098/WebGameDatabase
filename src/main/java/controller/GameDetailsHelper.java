package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.GameDetails;
import model.Player;

/**
 * @author Scott Grigsby-sdgrigsby
 *CIS175-Spring 2023
 * Feb 21, 2023
 */
public class GameDetailsHelper {

		static EntityManagerFactory emfactory= Persistence.createEntityManagerFactory("WebGameDatabase");

		public void insertNewGameDetails(GameDetails g) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(g);
			em.getTransaction().commit();
			em.close();
			}
		public List<GameDetails> getGames() {
			EntityManager em = emfactory.createEntityManager();
			List<GameDetails> allGameDetails = em.createQuery("SELECT d FROM GameDetails d").getResultList();
			return allGameDetails;
		}
		
		public List<Player> getPlayers() {
			EntityManager em = emfactory.createEntityManager();
			List<Player> allPlayers = em.createQuery("SELECT p FROM Player p").getResultList();
			return allPlayers;
		}
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

		public GameDetails searchForListDetailsById(int tempId) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			GameDetails found = em.find(GameDetails.class, tempId);
			em.close();
			return found;
		}

		public void updateList(GameDetails toEdit) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.merge(toEdit);em.getTransaction().commit();
			em.close();
		}
		/**
		 * @param tempId
		 * @return
		 */
		public GameDetails getPlayers(String tempId) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			GameDetails found = em.find(GameDetails.class, tempId);
			em.close();
			return found;
		}
}
