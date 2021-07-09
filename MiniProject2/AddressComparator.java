package wiley.training.advanced.miniproject2;

import java.util.*;

public class AddressComparator implements Comparator<Address>{

	@Override
	public int compare(Address o1, Address o2) {
		if(o1.city == o2.city)
			return o1.zipcode.compareTo(o2.zipcode);
		else
			return o1.city.compareTo(o2.city);
	}
	
}
