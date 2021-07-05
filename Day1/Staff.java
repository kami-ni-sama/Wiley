import java.util.*;
//This is an updated file
public class Staff {
	

	static class Employee implements Comparable{
		private String eName, eDesignation, eID;
		private double eSalary;
		int eAge;
		Scanner sc = new Scanner(System.in);
		
		Employee(){
			eName = "";
			eID = "Wil";
			eDesignation = "";
			eSalary = 0;//p:30k, m:35k, t:25k
			eAge = 0;
		}
		
		void create(int id) {
			this.eID += id;
			System.out.println("Enter name");
			this.eName = sc.nextLine();
			System.out.println("Enter designation");
			this.eDesignation = sc.nextLine();
			System.out.println("Enter the salary");
			this.eSalary = sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter age");
			this.eAge = sc.nextInt();
			sc.nextLine();
			
		}
		
		void display() {
			if(this.eName == "")
				return;
			System.out.println(this.eID+"\t"+this.eName+"\t\t\t"+this.eDesignation+"\t\t\t"+this.eSalary);
			
		}
		
		void raise(double percent) {
			double raise=this.eSalary*percent/100;
			this.eSalary+=raise;
		}

		@Override
		public int compareTo(Object o) {
			Employee emp = (Employee)o;
			if(this.eSalary > emp.eSalary)
				return 1;
			else if(this.eSalary < emp.eSalary)
				return -1;
			else
				return 0;
		}

	}
	
	
	
	public static void main(String[] args) {
//		Employee[] employees = new Employee[10];
		Scanner sc = new Scanner(System.in);
		ArrayList<Employee> employees = new ArrayList<Employee>();
		System.out.println("Enter the number of employees you need to enter the records for: ");
		int n = sc.nextInt();
		int i = 0;
		int choice;
		sc.nextLine();
		int displayFlag = 0;
		do{
			System.out.println("Enter the action you wish to perform : \n1)Create\n2)Display\n3)Raise Salary\n4)Delete\n5)Exit");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				String ch1;
				do {
					if(i>=n) {
						System.out.println("Limit exceeded, cannot add more employee records");
						break;
					}
					System.out.println("Creating record for employee "+(i+1));
					//employees[i] = new Employee();
					//employees[i].create(++i);
					employees.add(new Employee());
					employees.get(i).create(++i);//            [] ==> [10] ==> [10, 17]
//					System.out.println(employees);
					
					
					while(true) {
						System.out.println("Do you wish to continue (Y/N): ");
						ch1 = sc.nextLine();
						if(ch1.equalsIgnoreCase("Y") || ch1.equalsIgnoreCase("N")) {
							break;
						}
					}
				}while(ch1.equalsIgnoreCase("Y"));
				break;
			case 2:
				if(employees.isEmpty()) {
					System.out.println("Cannot display records, there are no entries");
					break;
				}
				displayFlag = 1;
				System.out.println("ID\tName\t\t\tDesignation\t\tSalary");
				Iterator<Employee> it = employees.iterator();
				while(it.hasNext())
					it.next().display();
				
//				for(int j = 0; j<i; j++) {
//					employees[j].display();
//				}
				break;
			case 3:
				if(employees.isEmpty()) {
					System.out.println("Cannot raise salaries, there are no entries");
					break;
				}
				if(displayFlag==0) {
					System.out.println("You cannot raise the salaries before displaying the employee records");
					break;
				}
				String ch2;
				do {double raisePercent;
					System.out.println("Out of "+i+" employees, enter the ID of employee you wish to give a raise to");
					int index2 = sc.nextInt();
					while(true) {
						System.out.println("Enter the precentage raise you wish to grant");
						raisePercent = sc.nextDouble();
						sc.nextLine();
						if(raisePercent<30)
							break;
						else
							System.out.println("Raise cannot be more than 30%");
					}
					employees.get(index2-1).raise(raisePercent);
					//employees[index2-1].raise(raisePercent);
					while(true) {
						System.out.println("Do you wish to provide raise to more employees (Y/N): ");
						ch2 = sc.nextLine();
						if(ch2.equalsIgnoreCase("Y") || ch2.equalsIgnoreCase("N")) {
							break;
						}
					}
				}while(ch2.equalsIgnoreCase("Y"));
				break;
			case 4:
				if(employees.isEmpty()) {
					System.out.println("Cannot delete records, there are no entries");
					break;
				}
				String ch3;
				do{
					System.out.println("Enter the id of the employee you wish to delete from records");
					int index3 = sc.nextInt();
					sc.nextLine();
					employees.remove(index3-1);
					while(true) {
						System.out.println("Do you wish to delete records of more employees (Y/N): ");
						ch3 = sc.nextLine();
						if(ch3.equalsIgnoreCase("Y") || ch3.equalsIgnoreCase("N")) {
							break;
						}
					}
				}while(ch3.equalsIgnoreCase("Y"));
				break;
			case 5:
				System.out.println("Closing the loop");
				break;
			default:
				System.out.println("Enter valid input");
				break;
			}
		}while(choice!=5);
		System.out.println("The entries after sorting are: ");
		Collections.sort(employees);
		System.out.println("ID\tName\t\t\tDesignation\t\tSalary");
		Iterator<Employee> it = employees.iterator();
		while(it.hasNext())
			it.next().display();
	sc.close();
	}

}
