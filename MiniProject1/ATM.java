package wiley.training.advanced.miniproject1;

import java.util.*;


public class ATM {

	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		int choice;
		do{
			Scanner sc = new Scanner(System.in);
			System.out.println("1)Create Account\n2)Credit\n3)Debit\n4)Check Balance\n5)Account Statement\n6)Update password\n7)Update Email\n8)Delete account\n9)Exit");
			choice = sc.nextInt();
			String name, email, password;
			int id;
			sc.nextLine();
			switch(choice) {
				case 1:
					System.out.println("Enter credentials to create account: ");
					System.out.println("Enter your full name: ");
					name = sc.nextLine();
					System.out.println("Enter your email id: ");
					email = sc.nextLine();
					System.out.println("Enter your password");
					password = sc.nextLine();
					customers.add(new Customer(name, email, password));
					break;
				case 2:
					System.out.println("Enter your unique email ");
					email = sc.nextLine();
					Customer credAcc = customers.stream().filter(c->email.equals(c.getCustEMail())).findFirst().orElse(null);
//					id = customers.stream().filter(c->c.getCustEMail().equals(email)).map(c->Integer.valueOf(c.getCustID()));
					System.out.println("Enter password: ");
					password = sc.nextLine();
					if(credAcc.checkPassword(credAcc.getCustID(), password)) {
						System.out.println("Enter the amount you wish to credit");
						double amount = sc.nextDouble();
						sc.nextLine();
						credAcc.credit(amount);
						System.out.println("Available balance is: "+credAcc.custBalance);
					}else System.out.println("Incorrect password");
					
					break;
				case 3:
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
						System.out.println("Available balance is: "+debAcc.custBalance);
					}else System.out.println("Incorrect password");
					
					break;
				case 4:
					System.out.println("Enter your unique email ");
					email = sc.nextLine();
					Customer balAcc = customers.stream().filter(c->email.equals(c.getCustEMail())).findFirst().orElse(null);
					System.out.println("Enter password: ");
					password = sc.nextLine();
					if(balAcc.checkPassword(balAcc.getCustID(), password))
						System.out.println("Available balance is: "+balAcc.custBalance);
					else System.out.println("Incorrect password");
					break;
				case 5:
					System.out.println("Enter your unique email ");
					email = sc.nextLine();
					Customer sumAcc = customers.stream().filter(c->email.equals(c.getCustEMail())).findFirst().orElse(null);
					System.out.println("Enter password: ");
					password = sc.nextLine();
					if(sumAcc.checkPassword(sumAcc.getCustID(), password))
						sumAcc.getAccountStatement();
					else System.out.println("Incorrect password");
					break;
				case 6:
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
					break;				
				case 7:
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
					break;
				case 8:
					System.out.println("Enter your unique email ");
					email = sc.nextLine();
					Customer delAcc = customers.stream().filter(c->email.equals(c.getCustEMail())).findFirst().orElse(null);
					System.out.println("Enter password: ");
					password = sc.nextLine();
					if(delAcc.checkPassword(delAcc.getCustID(), password)) {
						customers.remove(delAcc);
					}
					else System.out.println("Incorrect password");
					break;
				case 9:
					System.out.println("Closing the loop");
					break;				
				default:
					System.out.println("Enter valid input");
					break;
			}
//			sc.close();
		
		}while(choice!=9);
		
	}

}

