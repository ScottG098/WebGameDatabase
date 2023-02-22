package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameDetails;
import model.Player;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/playerNavigationServlet")
public class PlayerNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PlayerHelper dao = new PlayerHelper();
		String act = request.getParameter("doThisToList");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
		}else if (act.equals("delete")) {
			try {
				String tempId = request.getParameter("playerName");
				GameDetails PlayerToDelete = dao.searchForListDetailsById(tempId);
				dao.deletePlayer(PlayerToDelete);
			
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
				} finally { 
					getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
					}
			}
			else if(act.equals("add")) {
				getServletContext().getRequestDispatcher("/new-player.jsp").forward(request, response);
			}
	}

}
