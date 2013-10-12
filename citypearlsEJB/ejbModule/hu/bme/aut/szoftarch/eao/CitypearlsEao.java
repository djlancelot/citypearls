package hu.bme.aut.szoftarch.eao;

import hu.bme.aut.szoftarch.entities.User;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class CitypearlsEao
 */
@Stateless
@LocalBean
public class CitypearlsEao {
	 @PersistenceContext
	 EntityManager em;
    /**
     * Default constructor. 
     */
    public CitypearlsEao() {
        
    }
    

    @SuppressWarnings("unchecked")
    public List<User> getScores(Integer offset, Integer limit){
    	List<User> result;
        Query q = em.createQuery("SELECT u FROM User u ORDER BY u.score DESC");
        q.setMaxResults(limit);
        q.setFirstResult(offset);
        result = (List<User>)q.getResultList();
        return result;
    }
    
    public boolean authUser(String username, String password){
    	Query q = em.createQuery("select u from User u where u.username like :username and u.password like :password");
    	q.setParameter("username", username);
    	q.setParameter("password", password);
    	return true;
    }
    public long countUsers(){
    	long result;
        Query q = em.createQuery("select count(u) from User u");
        result = (Long)q.getSingleResult();
        return result;
    }

}
