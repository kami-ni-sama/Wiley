package wiley.training.advanced.miniproject1;

import java.util.*;


public class ATM {
	public static Scanner sc = new Scanner(System.in);
	static ArrayList<Customer> customers = new ArrayList<Customer>();
	public static void main(String[] args) {
		int choice;
		do{
			System.out.println("1)Create Account\t2)Credit\t3)Debit\n4)Transfer Funds\t5)Check Balance\t6)Account Statement\n7)Update Password\t8)Update Email\t9)Delete Account\n10)Exit");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
				case 1:
					createAccount();
					break;
				case 2:
					creditAccount();
					break;
				case 3:
					debitAccount();
					break;
				case 4:
					transferFunds();
					break;
				case 5:
					checkBalance();
					break;
				case 6:
					accountStatement();
					break;
				case 7:
					updatePassword();
					break;				
				case 8:
					updateEmail();
					break;
				case 9:
					deleteAccount();
					break;
				case 10:
					System.out.println("Closing the loop");
					break;		
				
				default:
					System.out.println("Enter valid input");
					break;
			}
//			sc.close();
		
		}while(choice!=10);
	}
	public static void createAccount() {
		String name, email, password;
		System.out.println("Enter credentials to create account: ");
		System.out.println("Enter your full name: ");
		name = sc.nextLine();
		System.out.println("Enter your email id: ");
		email = sc.nextLine();
		System.out.println("Enter your password");
		password = sc.nextLine();
		customers.add(new Customer(name, email, password));
	}
	
	public static void creditAccount() {
		String email, password;
		try {
			System.out.println("Enter your unique email ");
			email = sc.nextLine();
			Customer credAcc = customers.stream().filter(c->email.equals(c.getCustEMail())).findFirst().orElse(null);
			System.out.println("Enter password: ");
			password = sc.nextLine();
			if(credAcc.checkPassword(credAcc.getCustID(), password)) {
				System.out.println("Enter the amount you wish to credit");
				double amount = sc.nextDouble();
				sc.nextLine();
				credAcc.credit(amount);
				System.out.println("Available balance is: "+credAcc.getCustBalance());
			}else System.out.println("Incorrect password");
		}catch(NullPointerException e) {
			System.out.println("Account not registered");
		}
	}
	
	public static void debitAccount() {
		String email, password;
		try {
			System.out.println("Enter your unique email ");
			email = sc.nextLine();
			Customer debAcc = customers.stream().filter(c->email.equals(c.getCustEMail())).findFirst().orElse(null);
			System.out.println("Enter password: ");
			password = sc.nextLine();
			if(debAcc.checkPassword(debAcc.getCustID(), password)) {
				System.out.println("Enter the amount you wish to debit");
				double amount = sc.nextDouble();
				sc.nextLine();
				debAcc.debit(amount);
				System.out.println("Available balance is: "+debAcc.getCustBalance());
			}else System.out.println("Incorrect password");
		}catch(NullPointerException e) {
			System.out.println("Account not registered");
		}
	}
	
	public static void transferFunds() {
		String email, password;
		try {
			System.out.println("Enter your unique email ");
			email = sc.nextLine();
			Customer payerAcc = customers.stream().filter(c->email.equals(c.getCustEMail())).findFirst().orElse(null);
			System.out.println("Enter password: ");
			password = sc.nextLine();
			if(payerAcc.checkPassword(payerAcc.getCustID(), password)) {
				System.out.println("Enter the email of the account you wish to make transfer to");
				String payee = sc.nextLine();
				Customer payeeAcc = customers.stream().filter(c->payee.equals(c.getCustEMail())).findFirst().orElse(null);
				System.out.println("Enter the amount you wish to transfer");
				double amount = sc.nextDouble();
				sc.nextLine();
				payerAcc.debit(amount, payee);
				payeeAcc.credit(amount, email);
				System.out.println("Available balance is: "+payerAcc.getCustBalance());
			}else System.out.println("Incorrect password");
		}catch(NullPointerException e) {
			System.out.println("Account not registered");
		}
	}
	
	public static void checkBalance() {
		String email, password;
		try {
			System.out.println("Enter your unique email ");
			email = sc.nextLine();
			Customer balAcc = customers.stream().filter(c->email.equals(c.getCustEMail())).findFirst().orElse(null);
			System.out.println("Enter password: ");
			password = sc.nextLine();
			if(balAcc.checkPassword(balAcc.getCustID(), password))
				System.out.println("Available balance is: "+balAcc.getCustBalance());
			else System.out.println("Incorrect password");
		}catch(NullPointerException e) {
			System.out.println("Account not registered");
		}
	}
	
	public static void accountStatement() {
		String email, password;
		try {
			System.out.println("Enter your unique email ");
			email = sc.nextLine();
			Customer sumAcc = customers.stream().filter(c->email.equals(c.getCustEMail())).findFirst().orElse(null);
			System.out.println("Enter password: ");
			password = sc.nextLine();
			if(sumAcc.checkPassword(sumAcc.getCustID(), password))
				sumAcc.getAccountStatement();
			else System.out.println("Incorrect password");
		}catch(NullPointerException e) {
			System.out.println("Account not registered");
		}
	}
	
	public static void updatePassword() {
		String email, password;
		try {
			System.out.println("Enter your unique email ");
			email = sc.nextLine();
			Customer cpassAcc = customers.stream().filter(c->email.equals(c.getCustEMail())).findFirst().orElse(null);
			System.out.println("Enter password: ");
			password = sc.nextLine();
			if(cpassAcc.checkPassword(cpassAcc.getCustID(), password)) {
				System.out.println("Enter your new password");
				password = sc.nextLine();
				cpassAcc.changePassword(password);
			}
			else System.out.println("Incorrect password");
		}catch(NullPointerException e) {
			System.out.println("Account not registered");
		}
	}
	
	public static void updateEmail() {
		String email, password;
		try {
			System.out.println("Enter your unique email ");
			email = sc.nextLine();
			Customer cmailAcc = customers.stream().filter(c->email.equals(c.getCustEMail())).findFirst().orElse(null);
			System.out.println("Enter password: ");
			password = sc.nextLine();
			if(cmailAcc.checkPassword(cmailAcc.getCustID(), password)) {
				System.out.println("Enter your new email");
				String newEMail = sc.nextLine();
				cmailAcc.changeEMail(newEMail);
			}
			else System.out.println("Incorrect password");
		}catch(NullPointerException e) {
			System.out.println("Account not registered");
		}
	}
	
	public static void deleteAccount() {
		String email, password;
		try {
			System.out.println("Enter your unique email ");
			email = sc.nextLine();
			Customer delAcc = customers.stream().filter(c->email.equals(c.getCustEMail())).findFirst().orElse(null);
			System.out.println("Enter password: ");
			password = sc.nextLine();
			if(delAcc.checkPassword(delAcc.getCustID(), password)) {
				customers.remove(delAcc);
			}
			else System.out.println("Incorrect password");
		}catch(NullPointerException e) {
			System.out.println("Account not registered");
		}
	}
}

