package wiley.training.advanced.miniproject1;

import java.util.*;


public class ATM {

	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer("Ahmad", "ahmadj310599@gmail.com", "password1234"));
		customers.get(0).credit(3000);
		customers.get(0).debit(200);
		customers.get(0).credit(10000);
		customers.get(0).debit(5000);
		customers.get(0).getAccountStatement();
		Customer.setCustPassword(customers.get(0).getCustID(), "password4321");
		int choice;
		do{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the action you wish to perform : \n1)Credit\n2)Debit\n3)Check Balance\n4)Account Statement\n5)Update password\n6)Update Email\n7)Delete account\n8)Exit");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
				case 1:
				
					break;
				case 2:
				
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
					System.out.println("Closing the loop");
					break;				
				default:
					System.out.println("Enter valid input");
					break;
			}
			sc.close();
		
		}while(choice!=8);
		
	}

}

