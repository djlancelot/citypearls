package hu.bme.aut.szoftarch.service;

import hu.bme.aut.szoftarch.citypearlsEJB.CitypearlsBean;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScoreList
 */
@WebServlet("/ScoreList")
public class ScoreList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @EJB CitypearlsBean cpBean;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreList() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("userscores", cpBean.listScores(0, 10));
    	request.getRequestDispatcher("/WEB-INF/scorelist.jsp").forward(request, response);
    }
 
    @Override
    public String getServletInfo() { return "This is the simplest servlet listing the scores of the users."; }

}
