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
    
    final int userGroupId = 10;
    final int adminGroupId = 0;
    

    @SuppressWarnings("unchecked")
    public List<User> getScores(Integer offset, Integer limit){
    	List<User> result;
        Query q = em.createQuery("SELECT u, SUM  FROM User u");
        q.setMaxResults(limit);
        q.setFirstResult(offset);
        result = (List<User>)q.getResultList();
        return result;
    }
    
    public boolean authUser(String username, String password){
    	boolean result = false;
    	Query q = em.createQuery("select u from User u where u.username like :username and u.password like :password");
    	q.setParameter("username", username);
    	q.setParameter("password", password);
    	try {
    		q.getSingleResult();
    		result= true;
    	}catch(Exception e){
    		result = false;
    	}
    	return result;
    }
    public long countUsers(){
    	long result;
        Query q = em.createQuery("select count(u) from User u");
        result = (Long)q.getSingleResult();
        return result;
    }
    public long checkUserAndEmail(String email, String username){
    	long result;
        Query q = em.createQuery("select count(u) from User u where (u.username like :username or u.email like :email)");
        q.setParameter("username", username);
        q.setParameter("email", email);
        result = (Long)q.getSingleResult();
        return result;
    }
    public String regUser(String email, String username, String password) {
    	String message = new String();
    	if(checkUserAndEmail(email, username)>0){
    		message = "User and E-mail is already taken." ;
    	}else{
    		User reg= new User();
    		reg.setEmail(email);
    		reg.setPassword(password);
    		reg.setGroupid(userGroupId);
    		reg.setUsername(username);
    		em.persist(reg);
    		message="OK";
    	}
		return message;
	}
}
