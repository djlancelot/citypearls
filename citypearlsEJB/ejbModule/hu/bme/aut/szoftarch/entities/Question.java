package hu.bme.aut.szoftarch.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the questions database table.
 * 
 */
@Entity
@Table(name="questions")
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question extends hu.bme.aut.szoftarch.util.jpa.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String address;

	private String answer;

	private String banner;

	private String description;

	private float latitude;

	private float longtitude;

	private Integer point;

	private String question;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="lastQuestion")
	private Set<User> usersLastQuestion;

	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="question")
	private Set<Answer> answers;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="questions")
	private Set<User> usersAnswerredQuestion;

	public Question() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getBanner() {
		return this.banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongtitude() {
		return this.longtitude;
	}

	public void setLongtitude(float longtitude) {
		this.longtitude = longtitude;
	}

	public Integer getPoint() {
		return this.point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Set<User> getUsersLastQuestion() {
		return this.usersLastQuestion;
	}

	public void setUsersLastQuestion(Set<User> usersLastQuestion) {
		this.usersLastQuestion = usersLastQuestion;
	}

	public User addUsers1(User usersLastQuestion) {
		getUsersLastQuestion().add(usersLastQuestion);
		usersLastQuestion.setLastQuestion(this);

		return usersLastQuestion;
	}

	public User removeUsers1(User usersLastQuestion) {
		getUsersLastQuestion().remove(usersLastQuestion);
		usersLastQuestion.setLastQuestion(null);

		return usersLastQuestion;
	}

	public Set<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setQuestion(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setQuestion(null);

		return answer;
	}

	public Set<User> getUsersAnswerredQuestion() {
		return this.usersAnswerredQuestion;
	}

	public void setUsersAnswerredQuestion(Set<User> usersAnswerredQuestion) {
		this.usersAnswerredQuestion = usersAnswerredQuestion;
	}

}