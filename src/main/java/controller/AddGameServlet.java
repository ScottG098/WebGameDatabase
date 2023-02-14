package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameListItem;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addGameServlet")
public class AddGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("gameName");
		int playerNum = Integer.parseInt(request.getParameter("numOfPlayers"));
		
		GameListItem li = new GameListItem(name,playerNum);
		gameHelper dao = new gameHelper();
		dao.insertItem(li);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
