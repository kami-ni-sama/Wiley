package wiley.training.advanced.miniproject1;

public class ATM {

	public static void main(String[] args) {
		Customer c1 = new Customer("Ahmad", "ahmadj310599@gmail.com", "password1234");
		c1.credit(3000);
		c1.debit(200);
		c1.credit(10000);
		c1.debit(5000);
		c1.getAccountStatement();
		System.out.println(c1.getCustPassword());
		System.out.println(c1.getCustID());
		Customer.setCustPassword(c1.getCustID(), "password4321");
		System.out.println(c1.getCustPassword());
	}

}
