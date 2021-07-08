package wiley.training.advanced.miniproject1;

import java.util.*;


public class ATM {

	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer("A", "a", "p"));
		customers.get(0).credit(3000);
		customers.get(0).debit(200);
		customers.get(0).getAccountStatement();
		int choice;
		do{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the action you wish to perform : \n1)Create Account\n2)Credit\n3)Debit\n4)Check Balance\n5)Account Statement\n6)Update password\n7)Update Email\n8)Delete account\n9)Exit");
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
					Customer temp = customers.stream().filter(c->email.equals(c.getCustEMail())).findFirst().orElse(null);
//					id = customers.stream().filter(c->c.getCustEMail().equals(email)).map(c->Integer.valueOf(c.getCustID()));
					System.out.println("Enter password: ");
					password = sc.nextLine();
//					temp.checkPassword(email, password);
					if(temp.checkPassword(temp.getCustID(), password)) {
						System.out.println("Enter the amount you wish to credit");
						double amount = sc.nextDouble();
						sc.nextLine();
						temp.credit(amount);
					}
					temp.getAccountStatement();
//					customers.indexOf(id);
//					customers.stream().filter(c->c.getCustID().equals(id));
					break;
				case 3:
				
					break;
				case 4:
				
					break;
				case 5:
					
					break;
				case 6:
				
					break;				
				case 7:
				
					break;
				case 8:
					
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

