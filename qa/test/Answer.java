

/*
 * An answer belonging to a question, extends AbstractPost.
 */

public class Answer extends AbstractPost implements IVoteable{
	private Question correspondingQuestion;

	public Answer(String content, User owner, Question question){
		super(content, owner);
		this.correspondingQuestion = question;
	}

	public Question getCorrespondingQuestion() {
		return correspondingQuestion;
	}
	
	public String toString(){
		return "Answer: " + content + "\n Voting: " + voting + "\n";
	}
}
