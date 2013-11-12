package hu.bme.aut.szoftarch.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-12T23:35:06.694+0100")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, Integer> groupid;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, Question> lastQuestion;
	public static volatile SetAttribute<User, Answer> answers;
	public static volatile SetAttribute<User, Question> questions;
}
