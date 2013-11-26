package hu.bme.aut.szoftarch.dto;

public class QuestionDistList {
	private Integer id;

	private String address;

	private Integer point;

	private String question;
	
	private Double distance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double o) {
		this.distance = o;
	}

}
