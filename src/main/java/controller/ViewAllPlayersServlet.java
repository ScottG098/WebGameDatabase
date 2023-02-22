package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameDetails;
import model.Player;

/**
 * Servlet implementation class ViewAllPlayersServlet
 */
@WebServlet("/viewAllPlayersServlet")
public class ViewAllPlayersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllPlayersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GameDetailsHelper gdh = new GameDetailsHelper();
		List<Player> abc = gdh.getPlayers(); 
		request.setAttribute("allPlayers", abc);
		
		if(abc.isEmpty()) {
			request.setAttribute("allPlayers", " ");
		}
		
		getServletContext().getRequestDispatcher("/player-by-user.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
