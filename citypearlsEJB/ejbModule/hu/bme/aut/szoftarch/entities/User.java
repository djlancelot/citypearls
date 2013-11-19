package hu.bme.aut.szoftarch.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User extends hu.bme.aut.szoftarch.util.jpa.MyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String email;

	private Integer groupid;

	private String password;

	private String username;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="last_question")
	private Question lastQuestion;

	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="user")
	private Set<Answer> answers;

	//bi-directional many-to-many association to Question
	@ManyToMany
	@JoinTable(
		name="answers"
		, joinColumns={
			@JoinColumn(name="users_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="questions_id")
			}
		)
	private Set<Question> questions;

	public User() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGroupid() {
		return this.groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Question getLastQuestion() {
		return this.lastQuestion;
	}

	public void setLastQuestion(Question question) {
		this.lastQuestion = question;
	}

	public Set<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setUser(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setUser(null);

		return answer;
	}

	public Set<Question> getQuestions() {
		return this.questions;
	}

	public int getScore() {
		int sum =0;
		for (Question aq : this.questions){
			sum+=aq.getPoint();
		}
		return sum;
	}
	
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

}