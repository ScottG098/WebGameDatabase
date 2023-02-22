package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameDetails;
import model.GameListItem;
import model.Player;

/**
 * Servlet implementation class CreateNewPlayerServlet
 */
@WebServlet("/createNewPlayerServlet")
public class CreateNewPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewPlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		gameHelper lih = new gameHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: "+ listName);
		
		String playerName = request.getParameter("playerName");
		
		Player player = new Player(playerName);
		
		String[] selectedItems = request.getParameterValues("allGamesToAdd");
			List<GameListItem> selectedItemsInList = new ArrayList<GameListItem>();
			
			if (selectedItems != null && selectedItems.length > 0) 
			{
				for(int i = 0; i < selectedItems.length; i++) {
					System.out.println(selectedItems[i]);
					GameListItem c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));
					selectedItemsInList.add(c);
					}
				}
			GameDetails sld = new GameDetails(listName, player, selectedItemsInList);
			
	sld.setListOfGames(selectedItemsInList);
	GameDetailsHelper slh = new GameDetailsHelper();
	slh.insertNewGameDetails(sld);
	
	System.out.println("Success!");
	System.out.println(sld.toString());
	
	getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
