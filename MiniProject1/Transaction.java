package wiley.training.advanced.miniproject1;

//import java.util.HashMap;

enum TransactionType{Credit, Debit};

public class Transaction{
//	HashMap<Double, Double> transactionDenomination = new HashMap<>();
//	public static HashMap<Double, Double> availableDenomination = new HashMap<>();
	TransactionType transactionType;
	double transactionAmount;
	double updatedBalance;
	String payer;
	String payee;
	
	Transaction(TransactionType type, double transactionAmount, double updatedBalance, String payer, String payee){
		this.transactionType = type;
		this.transactionAmount = transactionAmount;
		this.updatedBalance = updatedBalance;
		this.payer = payer;
		this.payee = payee;
//		calculateDenomination(transactionAmount);
	}
	
	void calculateDenomination(double amount) {
		
	}
}
