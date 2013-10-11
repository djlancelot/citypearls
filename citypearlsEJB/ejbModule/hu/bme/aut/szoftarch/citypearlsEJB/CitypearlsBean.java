package hu.bme.aut.szoftarch.citypearlsEJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CitypearlsBean
 */
@Stateless
@LocalBean
public class CitypearlsBean implements CitypearlsInterface {
	
	/**
	 * The number of Quiz questions.
	 */
	public long quizCount;
    /**
     * Default constructor. 
     */
    public CitypearlsBean() {
        // TODO Auto-generated constructor stub
    }

}