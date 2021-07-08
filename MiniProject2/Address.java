package wiley.training.advanced.miniproject2;

public class Address {
	String city;
	String zipcode;
	public Address(String city, String zipcode) {
		this.city = city;
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return " [ " + this.city + " " + this.zipcode + " ] ";
	}
	
	
}
