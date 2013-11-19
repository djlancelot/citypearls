package hu.bme.aut.szoftarch.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-20T00:34:17.498+0100")
@StaticMetamodel(Question.class)
public class Question_ {
	public static volatile SingularAttribute<Question, Integer> id;
	public static volatile SingularAttribute<Question, String> address;
	public static volatile SingularAttribute<Question, String> answer;
	public static volatile SingularAttribute<Question, String> description;
	public static volatile SingularAttribute<Question, Float> latitude;
	public static volatile SingularAttribute<Question, Float> longtitude;
	public static volatile SingularAttribute<Question, Integer> point;
	public static volatile SingularAttribute<Question, String> question;
}
