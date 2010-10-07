

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;

@RunWith(JExample.class)
public class QuestionTest {
	
	public User user = new User("user", "secret");
	
	@Test
	public Question shouldBeOwnedByAUser(){
		Question testQuestion = new Question("A Question", user);
		assertEquals(user, testQuestion.getOwner());
		assertNotNull(testQuestion.getTimestamp());
		return testQuestion;
	}
	
	@Test
	@Given("#shouldBeOwnedByAUser")
	public void shouldBeVoteableUpAndDown(Question testQuestion){
		int oldVoting = testQuestion.getVoting();
		testQuestion.voteUp(user);
		assertEquals(oldVoting + 1, testQuestion.getVoting());
		oldVoting = testQuestion.getVoting();
		testQuestion.voteDown(user);
		assertEquals(oldVoting - 1, testQuestion.getVoting());
		
	}
	
	@Test(expected=AssertionError.class)
	@Given("#shouldBeOwnedByAUser")
	public void shouldNotBePossibleToVoteDownVotingOf0(Question testQuestion){
		testQuestion.voteDown(user);
		
	}

	@Test
	@Given("#shouldBeOwnedByAUser")
	public void shouldHaveATimestamp(Question testQuestion){
		assertNotNull(testQuestion.getTimestamp());
	}
}
