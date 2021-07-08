package wiley.training.advanced.day4;

import java.util.*;

public class UserSet{
	public static void main(String[] args) {
		TreeSet userSet = new TreeSet(new MyComparator());
//		TreeSet<User> userSet = new TreeSet<>((u1, u2)-> u2.getName().compareTo(u1.getName()));
		userSet.add(new Integer(2));
		userSet.add(new Integer(1));
		userSet.add(new User(2, "User2"));
		userSet.add(new User(1, "Adam"));
		userSet.add(new String("Hi"));
		userSet.add(new String("Hello"));
		userSet.forEach(System.out::println);
	}
}

class User implements Comparable{
	int id;
	String name;
	
	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}

class MyComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof User) {
			if(o2 instanceof User) {
				return ((User) o1).name.compareTo(((User) o2).name);
			}else if(o2 instanceof String) {
				return ((User) o1).name.compareTo(((String) o2));
			}
			return -1;
		}else if(o2 instanceof User) {
			if(o1 instanceof User) {
				return ((User) o2).name.compareTo(((User) o1).name);
			}else if(o2 instanceof String) {
				return ((User) o2).name.compareTo(((String) o1));
			}
			return 1;
		}
		if(o1 instanceof String) {
			if(o2 instanceof String) {
				return ((String) o1).compareTo(((String) o2));
			}else if(o2 instanceof User) {
				return ((String) o1).compareTo(((User) o2).name);
			}
			return -1;
		}else if(o2 instanceof String) {
			if(o1 instanceof String) {
				return ((String) o2).compareTo(((String) o1));
			}else if(o2 instanceof User) {
				return ((String) o2).compareTo(((User) o1).name);
			}
			return 1;
		}
		if(o1 instanceof Integer) {
			if(o2 instanceof Integer) {
				return (Integer)o1 - (Integer)o2;
			}
			return -1;
		}else if(o2 instanceof Integer) {
			if(o1 instanceof Integer) {
				return (Integer)o1 - (Integer)o2;
			}
			return 1;
		}
		return 0;
	}
	
}


// Case 2:
//class MyComparator implements Comparator{
//
//	@Override
//	public int compare(Object o1, Object o2) {
//		if(o1 instanceof String) {
//			if(o2 instanceof String) {
//				return ((String) o1).compareTo(((String) o2));
//			}
//			return -1;
//		}else if(o2 instanceof String) {
//			if(o1 instanceof String) {
//				return ((String) o2).compareTo(((String) o1));
//			}
//			return 1;
//		}
//		if(o1 instanceof User) {
//			if(o2 instanceof User) {
//				return ((User) o1).id - ((User) o2).id;
//			}
//			return -1;
//		}else if(o2 instanceof User) {
//			if(o1 instanceof User) {
//				return ((User) o2).id - ((User) o1).id;
//			}
//			return 1;
//		}
//		if(o1 instanceof Integer) {
//			if(o2 instanceof Integer) {
//				return (Integer)o1 - (Integer)o2;
//			}
//			return -1;
//		}else if(o2 instanceof Integer) {
//			if(o1 instanceof Integer) {
//				return (Integer)o1 - (Integer)o2;
//			}
//			return 1;
//		}
//		return 0;
//	}
//	
//}

// Case 1:
//class MyComparator implements Comparator{
//
//	@Override
//	public int compare(Object o1, Object o2) {
//		if(o1 instanceof Integer) {
//			if(o2 instanceof Integer) {
//				return (Integer)o1 - (Integer)o2;
//			}
//			return -1;
//		}else if(o2 instanceof Integer) {
//			if(o1 instanceof Integer) {
//				return (Integer)o1 - (Integer)o2;
//			}
//			return 1;
//		}
//		if(o1 instanceof User) {
//			if(o2 instanceof User) {
//				return ((User) o1).id - ((User) o2).id;
//			}
//			return -1;
//		}else if(o2 instanceof User) {
//			if(o1 instanceof User) {
//				return ((User) o2).id - ((User) o1).id;
//			}
//			return 1;
//		}
//		if(o1 instanceof String) {
//			if(o2 instanceof String) {
//				return ((String) o1).compareTo(((String) o2));
//			}
//			return -1;
//		}else if(o2 instanceof String) {
//			if(o1 instanceof String) {
//				return ((String) o2).compareTo(((String) o1));
//			}
//			return 1;
//		}
//		return 0;
//	}
//	
//}
