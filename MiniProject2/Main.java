package wiley.training.advanced.miniproject2;

import java.util.*;


/*
 * 
 * Implementation using ArrayLists
 * 
 * Input : 
 * [ 2 , User2,  [ [ DEL, 110001], [ BLR, 560001] ] ]
 * [ 1 , User1,  [ [ GN , 201305], [ BLR, 560001] ] ]
 * [ 3 , User3,  [ [ GN , 201305], [ BLR, 560001] ] ]
 * 
 * 1) Iterate over users
 * 2) Extract userAddress from the object
 * 3) Iterate on userAddress and add values to Address list (No duplicates)
 * 4) Loop : Address list : address
 * 			new NewAddress(address.city, address.zipcode);
 * 5) Loop : Address list : address
 * 			users.stream().filter(u->u.userAddress.contains(address)).forEach(u-> NewAddress.addUser(u.userId, u.userName)))
 * 
 * Output:
 * [ BLR , 560001 , [ [ 2 , User2 ] [ 1 , User1 ] [ 3 , User3 ] ] ]
 * [ GN  , 201305 , [ [ 1 , User1 ] [ 3 , User3 ] ] ]
 * [ DEL , 110001 , [ [ 1 , User1 ] ] ]
 * 
 */


public class Main {

	public static void main(String[] args) {
		Address a1 = new Address("DEL", "110001");
		Address a2 = new Address("BLR", "560001");
		Address a3 = new Address("GN", "201305");
		ArrayList<User> users = new ArrayList<>();
		ArrayList<Address> address2 = new ArrayList<>();
		address2.add(a1);
		address2.add(a2);
		ArrayList<Address> address1 = new ArrayList<>();
		address1.add(a3);
		address1.add(a2);
		ArrayList<Address> address3 = new ArrayList<>();
		address3.add(a3);
		address3.add(a2);
		users.add(new User(2, "User2", address2));
		users.add(new User(1, "User1", address1));
		users.add(new User(3, "User3", address3));
		System.out.println("Input format: ");
		users.forEach(System.out::println);
		ArrayList<Address> tempAddress = new ArrayList<>();
		HashSet<Address> address = new HashSet<>();
		for(User user:users)
			user.userAddress.stream().forEach(addr-> tempAddress.add(addr));
		for(Address tempaddress: tempAddress)
			if(tempAddress.stream().filter(a->a.equals(tempaddress)).count() > 1) 
				address.add(tempaddress);
		ArrayList<NewAddress> addresses = new ArrayList<>();
		for(Address addr:address) {
			addresses.add(new NewAddress(addr.city, addr.zipcode));
			users.stream().filter(user->user.userAddress.contains(addr)).forEach(user->{
				addresses.stream().filter(adr->(adr.newCity.equals(addr.city))).findFirst().orElse(null).addUser(user.userId, user.userName);
			});
		}
//		**Implementation using TreeMap		
//		TreeMap<Address, ArrayList<NewUser>> addresses = new TreeMap<>(new AddressComparator());
//		for(Address addr:address) {
//			ArrayList<NewUser> tempUsers = new ArrayList<>();
//			users.stream().filter(user->user.userAddress.contains(addr)).forEach(user->{
//				tempUsers.add( new NewUser(user.userId, user.userName));
//			});
//			addresses.put(addr, tempUsers);
//		}
//		System.out.println("Output format: ");
//		addresses.entrySet().forEach(System.out::println);
		
		
		for(NewAddress newAddress : addresses)
			Collections.sort(newAddress.users, new NewUserComparator());
		Collections.sort(addresses, new NewAddressComparator());
		System.out.println("Output format: ");
		addresses.forEach(System.out::println);
		
	}

}
