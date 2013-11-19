package hu.bme.aut.szoftarch.util;

import hu.bme.aut.szoftarch.citypearlsEJB.CitypearlsBean;
import hu.bme.aut.szoftarch.dto.UserData;
import hu.bme.aut.szoftarch.dto.UserScore;
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
        return result;
    }
}
