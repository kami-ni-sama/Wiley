package wiley.training.advanced.miniproject2;

import java.util.*;

public class NewAddress {
	String newCity;
	String newZipcode;
	ArrayList<NewUser> users;
	public NewAddress(String newCity, String newZipcode) {
		this.newCity = newCity;
		this.newZipcode = newZipcode;
		this.users = new ArrayList<NewUser>();
	}
	@Override
	public String toString() {
		return " [ " + this.newCity + " " + this.newZipcode + " " + this.users + " ] ";
	}
	
	void addUser(int id, String name) {
		this.users.add(new NewUser(id, name));
	}
	
}
