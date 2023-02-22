import java.util.List;

import controller.PlayerHelper;
import model.Player;

/**
 * @author Scott Grigsby-sdgrigsby
 *CIS175-Spring 2023
 * Feb 21, 2023
 */
public class PlayerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Player sam = new Player("Sam");
		
		Player tom = new Player("Tom");
		
		PlayerHelper ph = new PlayerHelper();
		
		ph.insertPLayer(sam);
		ph.insertPLayer(tom);
		
		List<Player> allPlayers = ph.showAllPlayers();
		for(Player a: allPlayers) {
			System.out.println(a.toString());
		}

	}

}
