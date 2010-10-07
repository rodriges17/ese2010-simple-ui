package models;

import java.util.ArrayList;

public class User {

	private String name;
	private String password;
	private ArrayList<Question> questions;
	private ArrayList<Answer> answers;
	private ArrayList<Vote> votes;

	public User(String name, String password){
		this.name = name;
		this.password = password;
		this.questions = new ArrayList<Question>();
		this.answers = new ArrayList<Answer>();
		this.votes = new ArrayList<Vote>();
	}

	public String getName() {
		return name;
	}

	public Question createQuestion(String string, User user) {
		Question question = new Question(string, user);
		user.registerQuestion(question);
		assert user.owns(question);
		return question;
	}

	private void registerQuestion(Question result) {
		questions.add(result);
		
	}

	public boolean owns(Question question) {
		return questions.contains(question);
		
	}
	
	public Object[] getQuestions(){
		return questions.toArray();
	}

	public Vote voteUp(Question question) {
		Vote vote = question.voteUp(this);
		votes.add(vote);
		return vote;
		
	}

	public void voteDown(Question question) {
		question.voteDown(this);
		
	}

	public Object[] getAnswers() {
		return answers.toArray();
	}

	public void delete() {
		name = null;
		questions = null;
		answers = null;
		votes = null;
	}

	public ArrayList<Vote> getVotes() {
		return votes;
	}
	
	public String toString(){
		return "name: " + name + "\nquestions: " + questions + "\nanswers: " + answers + "\nvotes: " + votes;
	}
}
