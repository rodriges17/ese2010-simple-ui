
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;

@RunWith(JExample.class)
public class UserTest {
	
	public Question question;
	
	@Test
	public User shouldHaveAName(){
		User testUser = new User("Test User", "secretTest");
		assertEquals("Test User", testUser.getName());
		return testUser;
	}
	
	@Test
	@Given("#shouldHaveAName")
	public User shouldBeAbleToOwnQuestions(User testUser){
		question = testUser.createQuestion("A Question", testUser);
		assertEquals(true, testUser.owns(question));	
		return testUser;
	}
	
	@Test
	@Given("#shouldBeAbleToOwnQuestions")
	public User shouldBeAbleToVoteQuestionsUpAndDown(User testUser){
		int oldVoting = question.getVoting();
		Vote vote = testUser.voteUp(question);
		assertEquals(oldVoting + 1, question.getVoting());
		assertEquals(true, testUser.getVotes().contains(vote));
		User testUser2 = new User ("Test User 2", "secretTest2");
		oldVoting = question.getVoting();
		testUser2.voteDown(question);
		assertEquals(oldVoting - 1, question.getVoting());
		return testUser;
	}

	@Test(expected=NullPointerException.class)
	@Given("#shouldBeAbleToVoteQuestionsUpAndDown")
	public void shouldBeDeleteable(User testUser){
		System.out.println(testUser);
		testUser.delete();
		assertNull(testUser.getQuestions());
		assertNull(testUser.getAnswers());
		assertNull(testUser.getVotes());
	}
	
	
}
