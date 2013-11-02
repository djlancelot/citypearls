package hu.bme.aut.szoftarch.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-02T14:28:58.840+0100")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, Integer> groupid;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, Integer> score;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, String> last_question;
}
