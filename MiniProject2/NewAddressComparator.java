package wiley.training.advanced.miniproject2;

import java.util.*;

public class NewAddressComparator implements Comparator<NewAddress>{

	@Override
	public int compare(NewAddress o1, NewAddress o2) {
		return o1.newCity.compareTo(o2.newCity);
	}

}
