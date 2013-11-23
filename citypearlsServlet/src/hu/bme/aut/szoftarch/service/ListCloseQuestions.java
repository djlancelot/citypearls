package hu.bme.aut.szoftarch.service;

import hu.bme.aut.szoftarch.citypearlsEJB.CitypearlsBean;
import hu.bme.aut.szoftarch.dto.UserData;

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
@WebServlet("/ListCloseQuestions")
public class ListCloseQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @EJB CitypearlsBean cpBean;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCloseQuestions() {
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
    	UserData u = (UserData) request.getSession().getAttribute("user");
    	if(u != null){
    		/// Logged in, show the menu
    		Float lat = 0.0f;
    		Float lng = 0.0f;
    		try{
    			lat = Float.parseFloat(request.getParameter("lat"));
    			lng = Float.parseFloat(request.getParameter("lng"));
    		}catch(Exception e){
    			lat = 0.0f;
    			lng = 0.0f;
    		}
    		request.setAttribute("questions", cpBean.getUnanswerredCloseQuestions(u, lat, lng));
    		request.setAttribute("user",request.getSession().getAttribute("user"));
        	request.getRequestDispatcher("/WEB-INF/listclosequestions.jsp").forward(request, response);
    	}else{
    		/// Not logged in, redirect to login
    		response.sendRedirect("Login");
    	}    	
    }
 
    @Override
    public String getServletInfo() { return "This is the simplest servlet listing the scores of the users."; }

}
