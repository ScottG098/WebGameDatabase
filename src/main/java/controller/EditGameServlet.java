package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameListItem;

/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editGameServlet")
public class EditGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		gameHelper dao = new gameHelper();
		
		String name = request.getParameter("gameName");
		int numOfPlayers = Integer.parseInt(request.getParameter("numOfPlayers"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		GameListItem itemToUpdate = dao.searchForItemById(tempId);
		itemToUpdate.setGameName(name);
		itemToUpdate.setNumOfPlayers(numOfPlayers);
		
		dao.updateItem(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllGamesServlet").forward(request, response);
	}

}
