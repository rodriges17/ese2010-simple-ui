package models;

import java.util.ArrayList;

import com.sun.jmx.snmp.Timestamp;

/*
 * A Post is either a question or an answer.
 * It has an owner(the guy who posted it), a content, a timestamp when it was published
 * an it saves its voting.
 * The voting is always bigger or equal to zero.
 */
public class AbstractPost implements IVoteable{

	String content;
	User owner;
	Timestamp timestamp;
	ArrayList<Vote> voting;

	public AbstractPost(String content, User owner) {
		this.content = content;
		this.owner = owner;
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.voting = new ArrayList<Vote>();
	}

	public User getOwner() {
		return owner;
	}

	public String getContent() {
		return content;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public int getVoting() {
		int sum = 0;
		for (Vote vote : voting){
			sum += vote.getVoting();
		}
		return sum;
	}

	public Vote voteUp(User voter) {
		Vote vote = new Vote(voter, this, 1);
		voting.add(vote);
		return vote;
	}

	public Vote voteDown(User voter) {
		assert getVoting() > 0;
		Vote vote = new Vote(voter, this, -1);
		voting.add(vote);
		return vote;
	}

}