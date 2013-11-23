package hu.bme.aut.szoftarch.citypearlsEJB;

import hu.bme.aut.szoftarch.dto.QuestionData;
import hu.bme.aut.szoftarch.dto.UserData;
import hu.bme.aut.szoftarch.dto.UserScore;



import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CitypearlsInterface {

	public List<UserScore> listScores(Integer offset, Integer limit);
	
	UserData authUser(String username, String password);
	
	long quizCount();

	long userCount();

	public List<Object[]> testScores();

	String regUser(String email, String username, String password);

	boolean isAdmin(String username);

	String addQuestion(UserData u, QuestionData qd);

}
