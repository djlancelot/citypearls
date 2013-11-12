package hu.bme.aut.szoftarch.citypearlsEJB;

import hu.bme.aut.szoftarch.dto.UserScore;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CitypearlsInterface {

	public List<UserScore> listScores(Integer offset, Integer limit);
	
	int authUser(String username, String password);
	
	long quizCount();

	long userCount();

	public List<Object[]> testScores();

}
