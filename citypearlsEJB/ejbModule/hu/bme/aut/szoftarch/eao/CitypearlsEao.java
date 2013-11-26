package hu.bme.aut.szoftarch.eao;

import hu.bme.aut.szoftarch.dto.QuestionDistList;
import hu.bme.aut.szoftarch.entities.Question;
import hu.bme.aut.szoftarch.entities.User;

import java.util.ArrayList;
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
    final int adminGroupId = 1;
    

    @SuppressWarnings("unchecked")
    public List<Object[]> getScores(Integer offset, Integer limit){
    	List<Object[]> result;
        Query q = em.createQuery("SELECT u, SUM(q.point) AS score FROM User u JOIN u.questions q GROUP BY u ORDER BY score DESC");
        q.setMaxResults(limit);
        q.setFirstResult(offset);
        result = (List<Object[]>)q.getResultList();
        return result;
    }
    public boolean isAdmin(String username){
    	boolean result = false;
    	User user = null;
    	Query q = em.createQuery("select u from User u where u.username like :username");
    	q.setParameter("username", username);
    	try {
    		 user = (User)q.getSingleResult();
    		 if(user.getGroupid()==adminGroupId){
    			 result = true;
    		 }
       	}catch(Exception e){
    		 user = null;
    	}
    	return result;
    }
    
    public void setLastQuestion(String username, int question_id){
    	Query q = em.createNativeQuery("UPDATE User u SET u.last_question = ?1 WHERE u.username LIKE '?2'");
    	if(question_id == 0){
    		question_id = getAQuestion(username);
    	}
    	q.setParameter(1, question_id);
    	q.setParameter(2, username);
    	q.executeUpdate();
    	
    }
    
    public User authUser(String username, String password){
    	User result = null;
    	Query q = em.createQuery("select u from User u where u.username like :username and u.password like :password");
    	q.setParameter("username", username);
    	q.setParameter("password", password);
    	try {
    		result = (User)q.getSingleResult();
       	}catch(Exception e){
    		result = null;
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
	public void addQuestion(Question q) {
		em.persist(q);
		
	}
	public int getAQuestion(String username) {
		String sqlString = "SELECT q.id FROM questions q WHERE q.id NOT IN (SELECT q.id FROM users u INNER JOIN answers a ON a.users_id = u.id INNER JOIN questions q ON  q.id = a.questions_id WHERE u.username LIKE '?1' ) LIMIT 1";
		Query q = em.createNativeQuery(sqlString);
		q.setParameter(1, username);
		return (int)q.getSingleResult();
	}
	public List<Object[]> getUnanswerredCloseQuestions(String username, Float lat,
			Float lng) {
		List<Object[]> result = new ArrayList<Object[]>();
		String sqlString = "SELECT q.id, q.address, q.question , q.point, geodistance(?1,?2,q.latitude,q.longtitude) as distance FROM questions q WHERE q.id NOT IN (SELECT q.id FROM users u INNER JOIN answers a ON a.users_id = u.id INNER JOIN questions q ON  q.id = a.questions_id WHERE u.username LIKE '?3' ) ORDER BY distance ASC";
		Query q = em.createNativeQuery(sqlString);
		q.setParameter(1, lat);
		q.setParameter(2, lng);
		q.setParameter(3, username);
		q.setMaxResults(5);
		//Query q = em.createQuery("SELECT q FROM Question q WHERE q.id NOT IN (SELECT q.id FROM User u JOIN u.questions q WHERE u.username LIKE :username )");
        //q.setMaxResults(limit);
        //q.setParameter("username", username);
        result = ((List<Object[]>)q.getResultList());

		return result;
	}
}
