package hu.bme.aut.szoftarch.dto;

public class UserData {
	private Integer id;

	private String email;

	private Integer groupid;

	private String username;
	
	private int lastQuestion;
	
	private int score;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getLastQuestion() {
		return lastQuestion;
	}

	public void setLastQuestion(int lastQuestion) {
		this.lastQuestion = lastQuestion;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
