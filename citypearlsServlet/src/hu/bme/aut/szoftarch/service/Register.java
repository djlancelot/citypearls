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
 * Servlet implementation class Login
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB CitypearlsBean cpBean;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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


	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		if((username != null) && (password != null) && (email != null)){
			/// Login parameters sent
			String message = cpBean.regUser(email,username, password);
			if(message.equals("OK")){
				// Authenticated, save info and redirect to profile
		    	response.sendRedirect("Login");	
			}else{
				// Bad data
				request.setAttribute("message", message);
				request.setAttribute("username", username);
				request.setAttribute("email", email);
				request.getRequestDispatcher("/WEB-INF/registerform.jsp").forward(request, response);
			}
		}else{
			/// Display login form
			request.setAttribute("message", "Please, enter user name and password.");
			request.getRequestDispatcher("/WEB-INF/registerform.jsp").forward(request, response);
		}
		
	}
    @Override
    public String getServletInfo() { return "This is the login form."; }
}
