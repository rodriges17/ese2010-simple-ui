

/*
 * A question, extends AbstractPost.
 */

public class Question extends AbstractPost implements IVoteable{

	public Question(String content, User owner){
		super(content, owner);
	}
	
	public String toString(){
		return "Question: " + content + " Voting: " + voting;
	}

}
