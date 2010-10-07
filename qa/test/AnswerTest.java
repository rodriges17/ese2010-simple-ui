import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;

@RunWith(JExample.class)
public class AnswerTest {
	
	public User user = new User("user", "secret");
	public User user2 = new User("user2", "secret2");
	public Question correspondingQuestion = new Question("Question", user2);
	
	@Test
	public Answer shouldBeOwnedByAUser(){
		Answer testAnswer = new Answer("An Answer", user, correspondingQuestion);
		assertEquals(user, testAnswer.getOwner());
		assertNotNull(testAnswer.getTimestamp());
		return testAnswer;
	}
	
	@Test
	@Given("#shouldBeOwnedByAUser")
	public void shouldBeVoteableUpAndDown(Answer testAnswer){
		int oldVoting = testAnswer.getVoting();
		testAnswer.voteUp(user);
		assertEquals(oldVoting + 1, testAnswer.getVoting());
		oldVoting = testAnswer.getVoting();
		testAnswer.voteDown(user2);
		assertEquals(oldVoting - 1, testAnswer.getVoting());
	}
	
	@Test(expected=AssertionError.class)
	@Given("#shouldBeOwnedByAUser")
	public void shouldNotBePossibleToVoteDownVotingOf0(Answer testAnswer){
		testAnswer.voteDown(user);
	}

	@Test
	@Given("#shouldBeOwnedByAUser")
	public void shouldHaveATimestamp(Answer testAnswer){
		assertNotNull(testAnswer.getTimestamp());
	}
	
	@Test
	@Given("#shouldBeOwnedByAUser")
	public void shouldBelongToAQuestion(Answer testAnswer){
		assertNotNull(testAnswer.getCorrespondingQuestion());
	}
}