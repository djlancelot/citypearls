package hu.bme.aut.szoftarch.dto;



public class UserScore {

	private Integer id;

	private Long score;

	private String username;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Long getScore() {
		return this.score;
	}

	public void setScore(Long o) {
		this.score = o;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


}
