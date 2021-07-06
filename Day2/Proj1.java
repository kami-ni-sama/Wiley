package wiley.training.advanced.day2;
import java.util.*;


public class Proj1{
	public static void main(String[] args) {
		ArrayList<User> users = new ArrayList<User>();
		Project p1 = new Project(1, "Project 1", 10000);
		Project p2 = new Project(2, "Project 2", 12000);
		Address a1 = new Address("Mumbai", "400706");
		Address a2 = new Address("Chennai", "403214");
		Address a3 = new Address("Chandigarh", "124325");
		Address a4 = new Address("Patna", "987643");
		Address a5 = new Address("Pune", "872343");
		Address a6 = new Address("Nagpur", "123098");
		users.add(new Employee("001", "User1",a1, p1, 5000));
		users.add(new Employee("002", "User2",a2, p1, 4000));
		users.add(new User("003", "User3"));
		users.add(new Employee("004", "User4",a3, p1, 3000));
		users.add(new Employee("005", "User5",a4, p2, 5000));
		users.add(new User("006", "User6"));
		users.add(new Employee("007", "User7",a5, p2, 6000));
		users.add(new Employee("008", "User8",a6, p2, 3000));
		users.add(new User("009", "User9"));
//		for(User u: users) {
//			u.display();
//		}
		
//		ArrayList<Employee> employees = new ArrayList<Employee>();
		ArrayList<Employee> employeesProj1 = new ArrayList<Employee>();
		ArrayList<Employee> employeesProj2 = new ArrayList<Employee>();
		for(User user: users) {
			if(user instanceof Employee) {
				if(((Employee) user).project.projectId==1) {
					Employee temp = (Employee)user;
					employeesProj1.add(temp);
				}
				if(((Employee) user).project.projectId==2) {
					Employee temp = (Employee)user;
					employeesProj2.add(temp);
				}
				
			}
		}
		
		double costIncurredProj1 = 0;
		for(Employee e: employeesProj1) 
			costIncurredProj1+=e.salary;
		Collections.sort(employeesProj1);
		while(costIncurredProj1 > employeesProj1.get(0).project.budget) {
			costIncurredProj1 -= employeesProj1.get(0).salary;
			employeesProj1.remove(0);
		}
		double costIncurredProj2 = 0;
		for(Employee e: employeesProj2) 
			costIncurredProj2+=e.salary;
		while(costIncurredProj2 > employeesProj2.get(0).project.budget) {
			costIncurredProj2 -= employeesProj2.get(0).salary;
			employeesProj2.remove(0);
		}
		System.out.println("Employees under project 1");
		for(Employee e: employeesProj1)
			e.display();
		System.out.println("Employees under project 2");
		for(Employee e: employeesProj2)
			e.display();
	}
}

class User {
	String id;
	String name;
	
	public User() {
		this.id = null;
		this.name = null;
	}
	
	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	void display() {
		System.out.println("User id: "+this.id);
		System.out.println("User name: "+this.name);
	}
	

}

class Employee extends User implements Comparable{
	Address address;
	Project project;
	double salary;
	public Employee(String id, String name, Address a, Project p, double salary) {
		super(id, name);
		this.address = a;
		this.project = p;
		this.salary = salary;
	}
	
	void display() {
		super.display();
		this.address.display();
		this.project.display();
		System.out.println("User salary: "+salary);
	}
	
	@Override
	public int compareTo(Object o) {
		Employee emp = (Employee)o;
		if(this.salary > emp.salary)
			return 1;
		else if(this.salary < emp.salary)
			return -1;
		else
			return 0;
	}
	

}

class Address{
	String city;
	String zipcode;
	
	public Address(String city, String zipcode) {
		this.city = city;
		this.zipcode = zipcode;
	}
	
	void display() {
		System.out.println("User city:"+this.city);
		System.out.println("User zipcode: "+this.zipcode);
	}
}

class Project{
	int projectId;
	String projName;
	double budget;
	
	public Project(int projectId, String projName, double budget) {
		this.projectId = projectId;
		this.projName = projName;
		this.budget = budget;
	}
	
	void display() {
		System.out.println("Project id: "+this.projectId);
		System.out.println("Project nameL "+this.projName);
		System.out.println("Project budget "+this.budget);
	}
}

