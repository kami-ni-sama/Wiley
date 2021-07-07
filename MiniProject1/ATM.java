package wiley.training.advanced.miniproject1;

public class ATM {

	public static void main(String[] args) {
		Customer c1 = new Customer("Ahmad", "ahmadj310599@gmail.com", "password1234");
		c1.credit(3000);
		c1.debit(200);
		c1.credit(10000);
		c1.debit(5000);
		c1.getAccountStatement();
		System.out.println(c1.getCustID());
		Customer.setCustPassword(c1.getCustID(), "password4321");
		
	}

}

/*
Output:

	Credit 3000.0 3000.0
	Debit 200.0 2800.0
	Credit 10000.0 12800.0
	Debit 5000.0 7800.0
	null
	CUST1
	null
	
*/
