package hu.bme.aut.szoftarch.entities;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-20T00:37:56.205+0100")
@StaticMetamodel(Answer.class)
public class Answer_ {
	public static volatile SingularAttribute<Answer, Integer> id;
	public static volatile SingularAttribute<Answer, Timestamp> time;
	public static volatile SingularAttribute<Answer, Question> question;
	public static volatile SingularAttribute<Answer, User> user;
}
