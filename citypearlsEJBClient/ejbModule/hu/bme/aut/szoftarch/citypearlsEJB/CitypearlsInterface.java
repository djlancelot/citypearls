package hu.bme.aut.szoftarch.citypearlsEJB;

import hu.bme.aut.szoftarch.dto.QuestionDump;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CitypearlsInterface {
	public QuestionDump dumpQuestions();
	long quizCount();

	long userCount();

}
