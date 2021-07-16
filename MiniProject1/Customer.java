package wiley.training.advanced.miniproject1;

import java.util.*;

public class Customer {
	private static int autoIncrementID = 0; 
	private String custName;
	private String custID;
	private String custEMail;
	private static HashMap<String, String> custPassword = new HashMap<String, String>();
	private double custBalance;
	private ArrayList<Transaction> custLog;
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
		Transaction t = new Transaction(TransactionType.Credit, creditAmount, this.custBalance, "Cash", this.custEMail);
		this.custLog.add(t);
	}
	
	void credit(double creditAmount, String payer) {
		this.custBalance += creditAmount;
		Transaction t = new Transaction(TransactionType.Credit, creditAmount, this.custBalance, payer, this.custEMail);
		this.custLog.add(t);
	}
	
	void debit(double debitAmount) {
		this.custBalance -= debitAmount;
		Transaction t = new Transaction(TransactionType.Debit, debitAmount, this.custBalance, this.custEMail, "Cash");
		this.custLog.add(t);
	}
	
	void debit(double debitAmount, String payee) {
		this.custBalance -= debitAmount;
		Transaction t = new Transaction(TransactionType.Debit, debitAmount, this.custBalance, this.custEMail, payee);
		this.custLog.add(t);
	}
	
	void getAccountStatement() {
		System.out.println("Account Statement for "+this.custName+" "+this.custEMail);
		System.out.println("Transaction Type\tPayer\tPayee\tTransaction Amount\tUpdated Balance");
		for(Transaction t: this.custLog)
			System.out.println(t.transactionType+"\t\t\t"+t.payer+"\t"+t.payee+"\t"+t.transactionAmount+"\t\t\t"+t.updatedBalance);
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
		String password = Customer.custPassword.get(newEMail);
		Customer.custPassword.remove(this.custEMail);
		Customer.custPassword.put(newEMail, password);
		this.custEMail = newEMail;
	}
	
//	static void printPasswords() {
//		for (Map.Entry<String, String> e : Customer.custPassword.entrySet())
//            System.out.println(e.getKey()+" "+e.getValue());
//	}
	
}
