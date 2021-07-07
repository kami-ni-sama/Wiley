package wiley.training.advanced.miniproject1;

import java.util.*;

enum TransactionType{Credit, Debit};


public class Customer {
	static int autoIncrementID = 0; 
	private String custName;
	private String custID;
	private String custEMail;
	private static HashMap<String, String> custPassword = new HashMap<String, String>();
	private double custBalance;
	private ArrayList<Transaction> custLog = new ArrayList<Transaction>();
	
	public Customer(String custName, String custEMail, String custPassword) {
		this.custName = custName;
		this.custID = "CUST" + ++autoIncrementID;
		this.custEMail = custEMail;
		Customer.custPassword.put(custEMail, custPassword);
		this.custBalance = 0.0;
		
	}
	
	
	public String getCustID() {
		return custID;
	}
	public void setCustEMail(String custEMail) {
		this.custEMail = custEMail;
	}
	public double getCustBalance() {
		return custBalance;
	}
	public static void setCustPassword(String custID, String custNewPassword) {
		Customer.custPassword.replace(custID, custNewPassword);
	}
	public String getCustPassword() {
		return Customer.custPassword.get(custID);
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
		for(Transaction t: this.custLog) {
			System.out.println(t.transactionType+" "+t.transactionAmount+" "+t.updatedBalance);
		}
	}
}
