package hu.bme.aut.szoftarch.citypearlsEJB;

import java.util.List;

import hu.bme.aut.szoftarch.dto.QuestionDump;
import hu.bme.aut.szoftarch.eao.CitypearlsEao;

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
	public QuestionDump dumpQuestions() {
		// TODO Auto-generated method stub
		return null;
	}

}
