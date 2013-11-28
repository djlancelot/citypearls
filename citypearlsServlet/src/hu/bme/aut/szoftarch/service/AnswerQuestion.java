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
 * Servlet implementation class Login
 */
@WebServlet("/AnswerQuestion")
public class AnswerQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB CitypearlsBean cpBean;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerQuestion() {
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
		UserData user = (UserData) request.getSession().getAttribute("user");
		String answer = request.getParameter("answer") + "";		
		if(user != null){
			/// Logged in
			if(cpBean.isGoodAnswer(user, answer)){
				// Answer right
				request.getRequestDispatcher("/WEB-INF/answerright.jsp").forward(request, response);
			}else{
				//answer wrong
				request.getRequestDispatcher("/WEB-INF/answerwrong.jsp").forward(request, response);
			}
	  	}else{
    		/// Not logged in, redirect to login
    		response.sendRedirect("Login");
    	}
	}
    @Override
    public String getServletInfo() { return "This is the answer evaluation."; }
}
