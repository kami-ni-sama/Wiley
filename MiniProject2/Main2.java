package wiley.training.advanced.miniproject2;

import java.util.*;


/*
 * Input : 
 * Input format: 
 * [ 2 User2 [ [ BOM 400018 ] ,  [ BOM 400037 ] ,  [ DEL 110001 ] ,  [ BLR 560001 ] ] ] 
 * [ 44 User44 [ [ BLR 560038 ] ,  [ DEL 110096 ] ,  [ DEL 110001 ] ] ] 
 * [ 3 User3 [ [ BLR 560001 ] ,  [ BLR 560002 ] ,  [ DEL 110001 ] ] ] 
 * 
 * Output format: 
 * [ DEL 110001 ] =[ [ 2 User2 ] ,  [ 44 User44 ] ,  [ 3 User3 ] ]
 * [ BLR 560001 ] =[ [ 2 User2 ] ,  [ 3 User3 ] ]
 * [ DEL 110096 ] =[ [ 44 User44 ] ]
 * [ BOM 400018 ] =[ [ 2 User2 ] ]
 * [ BOM 400037 ] =[ [ 2 User2 ] ]
 * [ BLR 560002 ] =[ [ 3 User3 ] ]
 * [ BLR 560038 ] =[ [ 44 User44 ] ]
 * 
 */


public class Main2 {

	public static void main(String[] args) {
		Address a1 = new Address("BLR", "560001");
		Address a2 = new Address("BLR", "560002");
		Address a3 = new Address("DEL", "110001");
		Address a4 = new Address("BLR", "560038");
		Address a5 = new Address("DEL", "110096");
		Address a6 = new Address("BOM", "400018");
		Address a7 = new Address("BOM", "400037");
		ArrayList<User> users = new ArrayList<>();
		ArrayList<Address> address3 = new ArrayList<>();
		address3.add(a1);
		address3.add(a2);
		address3.add(a3);
		ArrayList<Address> address44 = new ArrayList<>();
		address44.add(a4);
		address44.add(a5);
		address44.add(a3);
		ArrayList<Address> address2 = new ArrayList<>();
		address2.add(a6);
		address2.add(a7);
		address2.add(a3);
		address2.add(a1);
		users.add(new User(2, "User2", address2));
		users.add(new User(44, "User44", address44));
		users.add(new User(3, "User3", address3));
		System.out.println("Input format: ");
		users.forEach(System.out::println);
		ArrayList<Address> address = new ArrayList<>();
		for(User user:users)
			user.userAddress.stream().forEach(addr-> address.add(addr));
		address.forEach(System.out::println);
		TreeMap<Address, ArrayList<NewUser>> addresses = new TreeMap<>(new AddressComparator());
		
		for(Address addr:address) {
			ArrayList<NewUser> tempUsers = new ArrayList<>();
			users.stream().filter(user->user.userAddress.contains(addr)).forEach(user->{
				tempUsers.add( new NewUser(user.userId, user.userName));
			});
			addresses.put(addr, tempUsers);
		}
		
		System.out.println("Output format without sorting: ");
		addresses.entrySet().forEach(System.out::println);
		System.out.println("Output format with sorting: ");
		entriesSortedByValues(addresses).forEach(System.out::println);
		
	}
	
	static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<Address, ArrayList<NewUser>>> entriesSortedByValues(TreeMap<Address,ArrayList<NewUser>> map) {
	    SortedSet<Map.Entry<Address, ArrayList<NewUser>>> sortedEntries = new TreeSet<Map.Entry<Address,ArrayList<NewUser>>>(
	        new Comparator<Map.Entry<Address,ArrayList<NewUser>>>() {
	            @Override 
	            public int compare(Map.Entry<Address,ArrayList<NewUser>> e1, Map.Entry<Address,ArrayList<NewUser>> e2) {
	                int res = e2.getValue().size() - e1.getValue().size();
	                return res != 0 ? res : 1;
	            }
	        }
	    );
	    sortedEntries.addAll(map.entrySet());
	    return sortedEntries;
	}
}

/* Output:
 * [ DEL 110001 ] =[ [ 2 User2 ] ,  [ 44 User44 ] ,  [ 3 User3 ] ]
 * [ BLR 560001 ] =[ [ 2 User2 ] ,  [ 3 User3 ] ]
 * [ BLR 560002 ] =[ [ 3 User3 ] ]
 * [ BLR 560038 ] =[ [ 44 User44 ] ]
 * [ BOM 400018 ] =[ [ 2 User2 ] ]
 * [ BOM 400037 ] =[ [ 2 User2 ] ]
 * [ DEL 110096 ] =[ [ 44 User44 ] ]
 */




