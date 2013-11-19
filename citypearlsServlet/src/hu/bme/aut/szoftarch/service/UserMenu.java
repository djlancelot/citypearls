package hu.bme.aut.szoftarch.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserMenu
 */
@WebServlet("/UserMenu")
public class UserMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMenu() {
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
    	if(request.getSession().getAttribute("user") != null){
    		/// Logged in, show the menu
    		request.setAttribute("user",request.getSession().getAttribute("user"));
        	request.getRequestDispatcher("/WEB-INF/usermenu.jsp").forward(request, response);
    	}else{
    		/// Not logged in, redirect to login
    		response.sendRedirect("Login");
    	}
    }
 
    @Override
    public String getServletInfo() { return "This is the user menu for registered users."; }

}
