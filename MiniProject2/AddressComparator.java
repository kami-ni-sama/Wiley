package wiley.training.advanced.miniproject2;

import java.util.*;

public class AddressComparator implements Comparator<Address>{

	@Override
	public int compare(Address o1, Address o2) {
		return o1.city.compareTo(o2.city);
	}
	
}
