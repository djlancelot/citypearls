package hu.bme.aut.szoftarch.citypearlsEJB;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.szoftarch.dto.QuestionData;
import hu.bme.aut.szoftarch.dto.QuestionDistList;
import hu.bme.aut.szoftarch.dto.UserData;
import hu.bme.aut.szoftarch.dto.UserScore;
import hu.bme.aut.szoftarch.eao.CitypearlsEao;
import hu.bme.aut.szoftarch.entities.Question;
import hu.bme.aut.szoftarch.util.Converter;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Session Bean implementation class CitypearlsBean
 */
@Stateless
@LocalBean
@WebService
public class CitypearlsBean implements CitypearlsInterface {
	@EJB CitypearlsEao eao;
	@EJB Converter conv;
	/**
	 * The number of Quiz questions.
	 */
	@Override
	public long quizCount() {
		return 17; //FIXME call the EAO method
	}
	@Override
	public long userCount(){
		return eao.countUsers();
	}
	/**
     * Default constructor. 
     */
    public CitypearlsBean() {
       
    }
    @Override
	public List<Object[]> testScores() {
    return  eao.getScores(0, 50);
	}
	
	@Override
    public boolean isAdmin(String username){
    	return eao.isAdmin(username);
    }
	@Override
	public List<UserScore> listScores(Integer offset, Integer limit) {
		List<UserScore> result= new ArrayList<UserScore>();
		for(Object[] u: eao.getScores(offset, limit)){
			result.add(conv.fromScoreResult(u));
		}
		return result;
	}
	@Override
	public UserData authUser(String username, String password) {		
		return conv.dataFromEntity(eao.authUser(username, password));
	}
	@Override
	public String regUser(String email, String username, String password) {
		return eao.regUser(email,username,password);
	}
	@Override
	public String addQuestion(UserData userData, QuestionData qd) {
		String result = "Unknown error";
		if(isAdmin(userData.getUsername())){
			eao.addQuestion((Question)conv.entityFromData(qd));
			result = "Successfully added";
		}else{
			result = "No privileges.";
		}
		return result;
	}
	@Override
	public List<QuestionDistList> getUnanswerredCloseQuestions(UserData u, Float lat, Float lng){
		List<QuestionDistList> result = new ArrayList<QuestionDistList>();
		for(Object[] q:	eao.getUnanswerredCloseQuestions(u.getUsername(),lat,lng)){
			result.add(conv.dataFromDistEntity(q));
		}
		return result;		
	}
	@Override
	public QuestionData getUserQuestion(UserData user){
		return conv.dataFromQEntity(eao.getUsersQuestion(user.getUsername()));		
	}

	@Override
    public int setLastQuestion(UserData user, int question_id){
		return eao.setLastQuestion(user.getUsername(), question_id);
	}
}
