

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;

@RunWith(JExample.class)
public class VoteTest {

	@Test
	public static void shouldBelongToAUser(){
		User questioner = new User("questioner", "secret");
		User voter = new User("voter", "secret");
		Question voteReciever = new Question("Question", questioner);
		Vote vote = voter.voteUp(voteReciever);
		assertEquals(voter, vote.getVoter());
	}
	
}
