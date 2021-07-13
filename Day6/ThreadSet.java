package wiley.training.advanced.day6;

import java.util.*;

public class ThreadSet implements Runnable  {
	List<Users> ls=new ArrayList<Users>();
	String s="";
	Project p=new Project(0, s);
	boolean eof=false;
	
	@Override
	public void run() {
		Iterator<Users> itr=ls.iterator();
		while(itr.hasNext()) {
			Users u1=(Users) itr.next();
			Iterator<?> itr2= u1.project.iterator();
			s=(u1.name)+"  "+(u1.id);
			while(itr2.hasNext()) {
				Project p2=(Project) itr2.next();
				p=p2;
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
		eof=true;
		
	}

	public static void main(String[] args) throws InterruptedException {
		Project p1=new Project(1,"Porject 1");
		Project p2=new Project(2,"Project 2");
		Project p3=new Project(1,"Porject 1");
		ThreadSet ob1= new ThreadSet();
		Thread th1=new Thread(ob1);
		List<Project> ll1=new ArrayList<Project>();
		ll1.add(p1);
		ll1.add(p2);
		ob1.ls.add(new Users("User 1",1, ll1));
		th1.start();
		ThreadSet ob2= new ThreadSet();
		Thread th2=new Thread(ob2);
		List<Project> ll2=new ArrayList<Project>();
		ll2.add(p2);
		ll2.add(p3);
		ob2.ls.add(new Users("User 2",2, ll2));
		th2.start();
		HashMap<Project,String> hm=new HashMap<Project,String>();
		while(!ob1.eof || !ob2.eof) {
			hm.put(ob1.p,ob1.s);
			hm.put(ob2.p, ob2.s);
			Thread.sleep(100);
		}
		Thread.sleep(1);
		hm.entrySet().forEach(System.out::println);
	}
}
class Users{
	String name;
	int id;
	List<Project> project;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Users(String name, int id, List<Project> project) {
		super();
		this.name = name;
		this.id = id;
		this.project = project;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Project> getProject() {
		return project;
	}
	public void setProject(List<Project> project) {
		this.project = project;
	}
}
class Project{
	int id;
	String name;
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public Project(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Project [id=" + this.id + ", name=" + this.name + "]";
	}
}