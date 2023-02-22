package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Scott Grigsby-sdgrigsby
 *CIS175-Spring 2023
 * Feb 21, 2023
 */
@Entity
public class GameDetails {
	
	@Id
	@GeneratedValue
	private int id;
	private String playerListName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Player player;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<GameListItem> listOfGames;
	
	
	/**
	 * 
	 */
	public GameDetails() {
		super();
	}


	/**
	 * @param playerListName
	 * @param player
	 * @param listOfGames
	 */
	public GameDetails(String playerListName, Player player, List<GameListItem> listOfGames) {
		super();
		this.playerListName = playerListName;
		this.player = player;
		this.listOfGames = listOfGames;
	}


	/**
	 * @param playerListName
	 * @param player
	 */
	public GameDetails(String playerListName, Player player) {
		super();
		this.playerListName = playerListName;
		this.player = player;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the playerListName
	 */
	public String getPlayerListName() {
		return playerListName;
	}


	/**
	 * @param playerListName the playerListName to set
	 */
	public void setPlayerListName(String playerListName) {
		this.playerListName = playerListName;
	}


	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}


	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}


	/**
	 * @return the listOfGames
	 */
	public List<GameListItem> getListOfGames() {
		return listOfGames;
	}


	/**
	 * @param listOfGames the listOfGames to set
	 */
	public void setListOfGames(List<GameListItem> listOfGames) {
		this.listOfGames = listOfGames;
	}


	@Override
	public String toString() {
		return "GameDetails [id=" + id + ", playerListName=" + playerListName + ", player=" + player + ", listOfGames="
				+ listOfGames + "]";
	}

}
