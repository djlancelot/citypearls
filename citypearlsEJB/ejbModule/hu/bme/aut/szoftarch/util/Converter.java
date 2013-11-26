package hu.bme.aut.szoftarch.util;

import hu.bme.aut.szoftarch.citypearlsEJB.CitypearlsBean;
import hu.bme.aut.szoftarch.dto.QuestionData;
import hu.bme.aut.szoftarch.dto.QuestionDistList;
import hu.bme.aut.szoftarch.dto.UserData;
import hu.bme.aut.szoftarch.dto.UserScore;
import hu.bme.aut.szoftarch.entities.Question;
import hu.bme.aut.szoftarch.entities.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Converter
 */
@Stateless
public class Converter {

	@EJB CitypearlsBean eao;
    /**
     * Default constructor. 
     */
    public Converter() {

    }
    public UserScore fromScoreResult(Object[] o) {
        UserScore result = new UserScore();
        User e = (User)o[0];
        result.setUsername(e.getUsername());
        result.setId(e.getId());
        result.setScore((Integer)o[2]);
        return result;
    }
    public UserScore scoreFromEntity(User e) {
        UserScore result = new UserScore();
        result.setUsername(e.getUsername());
        result.setId(e.getId());
        result.setScore(e.getScore());
        return result;
    }
    public UserData dataFromEntity(User e) {
        UserData result = new UserData();
        result.setUsername(e.getUsername());
        result.setId(e.getId());
        result.setScore(e.getScore());
        result.setGroupid(e.getGroupid());
        return result;
    }
	public Object entityFromData(QuestionData qd) {
		Question q = new Question();
		q.setAddress(qd.getAddress());
		q.setAnswer(qd.getAnswer());
		q.setBanner(qd.getBanner());
		q.setDescription(qd.getDescription());
		q.setLatitude(qd.getLatitude());
		q.setLongtitude(qd.getLongtitude());
		q.setPoint(qd.getPoint());
		q.setQuestion(qd.getQuestion());
		return q;
	}
	public QuestionData dataFromQEntity(Question qd) {
		QuestionData q = new QuestionData();
		q.setAddress(qd.getAddress());		
		q.setBanner(qd.getBanner());
		q.setDescription(qd.getDescription());
		q.setLatitude(qd.getLatitude());
		q.setLongtitude(qd.getLongtitude());
		q.setPoint(qd.getPoint());
		q.setQuestion(qd.getQuestion());
		return q;
	}
	public QuestionDistList dataFromDistEntity(Object[] o) {
		// TODO Auto-generated method stub
		// q.id, q.address, q.question , q.point, geodistance
		QuestionDistList q = new QuestionDistList();
		q.setId((int)o[0]);
		q.setAddress((String)o[1]);
		q.setQuestion((String)o[2]);
		q.setPoint((int)o[3]);
		q.setDistance((Double)o[4]);
		return q;
	}
}
