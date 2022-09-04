package trees;

public class Question {
	String content;
	Question yes, no;
	
	public Question() {
		content = null;
		yes = null;
		no = null;
	}
	
	public Question(String content) {
		this.content = content;
	}
	
	public Question(String content, Question yes, Question no) {
		this.content = content;
		this.yes = yes;
		this.no = no;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setNo(Question no) {
		this.no = no;
	}
	
	public Question getNo() {
		return no;
	}
	
	public void setYes(Question yes) {
		this.yes = yes;
	}
	
	public Question getYes() {
		return yes;
	}
	
	public Question getFollowingQuestionByAnswer(Answer answer) {
		return answer == Answer.YES ? yes : no;
	}
}
