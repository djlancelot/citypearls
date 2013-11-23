package hu.bme.aut.szoftarch.service;

import hu.bme.aut.szoftarch.citypearlsEJB.CitypearlsBean;
import hu.bme.aut.szoftarch.dto.QuestionData;
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
@WebServlet("/AddQuestion")
public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB CitypearlsBean cpBean;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestion() {
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
		UserData user = (UserData)request.getSession().getAttribute("user");
		if(user != null){
			
			/// Logged in, show the form
			QuestionData qd = getQuestion(request);
			String res = "Wrong parameters.";
			if(qd != null){
				res = cpBean.addQuestion(user, qd);
			}
			request.setAttribute("message", res);
        	request.getRequestDispatcher("/WEB-INF/addquestionform.jsp").forward(request, response);
    	}else{
    		/// Not logged in, redirect to login
    		response.sendRedirect("Login");
    	}
	}
    private QuestionData getQuestion(HttpServletRequest request) {
    	QuestionData qd = null;
    	String question = (String) request.getParameter("question");
    	String answer = (String) request.getParameter("answer");
    	String point = (String) request.getParameter("point");
    	String latitude = (String) request.getParameter("latitude");
    	String longtitude = (String) request.getParameter("longtitude");
    	String description = (String) request.getParameter("description");
    	String banner = (String) request.getParameter("banner");
    	String address = (String) request.getParameter("address");
		if((question != null )&&
			(answer != null ) &&
			(point != null ) &&
			(latitude != null ) &&
			(longtitude != null )
				)
		{
			qd = new QuestionData();
			qd.setAddress(address);
			qd.setBanner(banner);
			qd.setAnswer(answer);
			qd.setDescription(description);
			qd.setLatitude(Float.parseFloat(latitude));
			qd.setLongtitude(Float.parseFloat(longtitude));
			qd.setPoint(Integer.parseInt(point));
			qd.setQuestion(question);
			
		}
		return qd;
	}

	@Override
    public String getServletInfo() { return "This is the login form."; }
}
