package wiley.training.advanced.miniproject2;

import java.util.*;

public class UserComparator implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		return o1.userId - o2.userId;
	}
	
}
