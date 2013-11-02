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
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
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
    	if(request.getSession().getAttribute("username") == null){
    		/// Not Logged in, see what we cab do
    		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    	}else{
    		/// Logged in, redirect to menu
    		response.sendRedirect("UserMenu");
    	}
    }
 
    @Override
    public String getServletInfo() { return "This is the user menu for registered users."; }

}
