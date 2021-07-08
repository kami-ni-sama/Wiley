package wiley.training.advanced.miniproject2;

public class NewUser {
	int newUserId;
	String newUserName;
	public NewUser(int newUserId, String newUserName) {
		this.newUserId = newUserId;
		this.newUserName = newUserName;
	}
	@Override
	public String toString() {
		return " [ " + this.newUserId + " " + this.newUserName + " ] ";
	}
	
}
