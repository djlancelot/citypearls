package hu.bme.aut.szoftarch.citypearlsEJB;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.szoftarch.dto.UserData;
import hu.bme.aut.szoftarch.dto.UserScore;
import hu.bme.aut.szoftarch.eao.CitypearlsEao;
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
	public String regUser(String email, String username, String password) {
		return eao.regUser(email,username,password);
	}

}
