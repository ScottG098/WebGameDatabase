package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Scott Grigsby-sdgrigsby
 *CIS175-Spring 2023
 * Feb 21, 2023
 */
@Entity
@Table(name="Players")
public class Player {

	@Id
	@GeneratedValue
	private int id;
	private String playerName;
	/**
	 * 
	 */
	public Player() {
		super();
	}
	/**
	 * @param id
	 * @param playerName
	 */
	public Player(int id, String playerName) {
		super();
		this.id = id;
		this.playerName = playerName;
	}
	/**
	 * @param playerName
	 */
	public Player(String playerName) {
		super();
		this.playerName = playerName;
	}
	/**
	 * @param tempId
	 */
	public Player(int id) {
		super();
		this.id = id;
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
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}
	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	@Override
	public String toString() {
		return "Player [id=" + id + ", playerName=" + playerName + "]";
	}
	
	
}
