package hu.bme.aut.szoftarch.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-10-11T22:19:06.795+0200")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, Integer> groupid;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Integer> score;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, String> email;
}
