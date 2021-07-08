package wiley.training.advanced.miniproject2;

import java.util.*;

public class User {
	int userId;
	String userName;
	ArrayList<Address> userAddress;
	public User(int userId, String userName, ArrayList<Address> userAddress) {
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
	}
	@Override
	public String toString() {
		return " [ " + this.userId + " " + this.userName + " " + this.userAddress + " ] ";
	}
	
	boolean checkCities(String city) {
		for(Address a:this.userAddress) {
			if(a.city.equals(city))
				return true;
		}
		return false;
	}
	
	
}
