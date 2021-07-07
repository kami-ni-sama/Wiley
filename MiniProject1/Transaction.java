package wiley.training.advanced.miniproject1;

public class Transaction{
	TransactionType transactionType;
	double transactionAmount;
	double updatedBalance;
	Transaction(TransactionType type, double transactionAmount, double updatedBalance){
		this.transactionType = type;
		this.transactionAmount = transactionAmount;
		this.updatedBalance = updatedBalance;
	}
}

