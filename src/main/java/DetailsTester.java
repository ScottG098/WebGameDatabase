import java.util.ArrayList;
import java.util.List;

import controller.GameDetailsHelper;
import controller.PlayerHelper;
import model.GameDetails;
import model.GameListItem;
import model.Player;

/**
 * @author Scott Grigsby-sdgrigsby
 *CIS175-Spring 2023
 * Feb 21, 2023
 */
public class DetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GameListItem monopoly = new GameListItem();
		
		PlayerHelper ph = new PlayerHelper();
		
		GameDetailsHelper gdh = new GameDetailsHelper();
		
		Player mike = new Player("Mike");
		Player ben = new Player("Ben");
		
		List<Player> monopolyPlayers = new ArrayList<Player>();
		monopolyPlayers.add(mike);
		monopolyPlayers.add(ben);
		
		
		GameDetails monopolyList = new GameDetails("Monopoly Players", monopoly);
		
		monopolyList.setListOfPlayers(monopolyPlayers);
		
		gdh.insertNewGameDetails(monopolyList);
		
		List<GameDetails> allGames = gdh.getGames();
		
		for (GameDetails a : allGames) {
			System.out.println(a.toString());
		}

	}

}
