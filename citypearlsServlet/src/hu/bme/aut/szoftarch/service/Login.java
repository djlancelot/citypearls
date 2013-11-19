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
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB CitypearlsBean cpBean;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if((username != null) && (password != null)){
			/// Login parameters sent
			UserData user = cpBean.authUser(username, password);
			if(user != null){
				// Authenticated, save info and redirect to profile
				loginUser(request.getSession(),user);
		    	response.sendRedirect("UserMenu");	
			}else{
				// Bad password
				request.setAttribute("message", "Bad username or password.");
				request.setAttribute("username", username);
				request.getRequestDispatcher("/WEB-INF/loginform.jsp").forward(request, response);
			}
		}else{
			/// Display login form
			request.setAttribute("message", "Please, enter user name and password.");
	    	request.getRequestDispatcher("/WEB-INF/loginform.jsp").forward(request, response);
		}
		
	}
    @Override
    public String getServletInfo() { return "This is the login form."; }
}
