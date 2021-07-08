package wiley.training.advanced.miniproject1;

import java.util.*;

public class Customer {
	static int autoIncrementID = 0; 
	String custName;
	String custID;
	String custEMail;
	static HashMap<String, String> custPassword = new HashMap<String, String>();
	double custBalance;
	ArrayList<Transaction> custLog;
	// = new ArrayList<Transaction>()
	
	public Customer(String custName, String custEMail, String custPassword) {
		this.custName = custName;
		this.custID = "CUST" + ++autoIncrementID;
		this.custEMail = custEMail;
		Customer.custPassword.put(custID, custPassword);
		this.custBalance = 0.0;
		this.custLog = new ArrayList<Transaction>();
	}
	
	public String getCustID() {
		return custID;
		
	}
	public void setCustEMail(String custEMail) {
		this.custEMail = custEMail;
	}
	public String getCustEMail() {
		return this.custEMail;
	}
	public double getCustBalance() {
		return custBalance;
	}
	public static void setCustPassword(String custID, String custNewPassword) {
		Customer.custPassword.replace(custID, custNewPassword);
	}

	void credit(double creditAmount) {
		this.custBalance += creditAmount;
		Transaction t = new Transaction(TransactionType.Credit, creditAmount, this.custBalance);
		this.custLog.add(t);
	}
	
	void debit(double debitAmount) {
		this.custBalance -= debitAmount;
		Transaction t = new Transaction(TransactionType.Debit, debitAmount, this.custBalance);
		this.custLog.add(t);
	}
	
	void getAccountStatement() {
		System.out.println("Account Statement for "+this.custName+" "+this.custEMail);
		System.out.println("Transaction Type\tTransaction Amount\tUpdated Balance");
		for(Transaction t: this.custLog)
			System.out.println(t.transactionType+"\t\t\t"+t.transactionAmount+"\t\t\t"+t.updatedBalance);
	}
	
	boolean checkPassword(String id, String pass) {
		if(Customer.custPassword.get(id) != null) {
			if(Customer.custPassword.get(id).equals(pass)) {
				return true;
			}
		}
		return false;
	}
	
	void changePassword(String newPassword) {
		Customer.setCustPassword(this.custID, newPassword);
	}
	
	void changeEMail(String newEMail) {
		this.custEMail = newEMail;
	}
	
//	static void printPasswords() {
//		for (Map.Entry<String, String> e : Customer.custPassword.entrySet())
//            System.out.println(e.getKey()+" "+e.getValue());
//	}
	
}
