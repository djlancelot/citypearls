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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/SetQuestion")
public class SetQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB CitypearlsBean cpBean;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetQuestion() {
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

	private void loginUser(HttpSession s, UserData user){
		s.setAttribute("user", user);
	}
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserData user = (UserData) request.getSession().getAttribute("user");
		int qid = 0;
		try{
			qid = Integer.parseInt(request.getParameter("qid"));
		}catch (Exception e){
			// Nothing serious, just a nullpointer 
			qid =0;
		}
		if(user != null){
			/// Logged in
			cpBean.setLastQuestion(user, qid);
			response.sendRedirect("ViewQuestion");
	  	}else{
    		/// Not logged in, redirect to login
    		response.sendRedirect("Login");
    	}
	}
    @Override
    public String getServletInfo() { return "This is the login form."; }
}
