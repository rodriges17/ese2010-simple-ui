package models;

/*
 * A vote can have two different voting values. 1 for a positive vote and -1 for a negative one.
 * Votes are created when a user votes up or down a question or an answer.
 * A vote belongs to a voter and the corresponding question or answer.
 */
public class Vote {
	
	private User voter;
	private AbstractPost receiver;
	private int voting;

	public Vote(User voter, AbstractPost receiver, int value) {
		this.voter = voter;
		this.receiver = receiver;
		this.voting = value;
	}

	public User getVoter() {
		return voter;
	}

	public AbstractPost getReceiver() {
		return receiver;
	}

	public int getVoting() {
		return voting;
	}

	public String toString(){
		return  "voting: " + voting;
	}

}
