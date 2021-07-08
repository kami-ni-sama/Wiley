package wiley.training.advanced.miniproject2;

import java.util.*;

public class NewUserComparator implements Comparator<NewUser>{

	@Override
	public int compare(NewUser o1, NewUser o2) {
		return o1.newUserId - o2.newUserId;
	}
	
}
