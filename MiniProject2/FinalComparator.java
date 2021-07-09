package wiley.training.advanced.miniproject2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class FinalComparator implements Comparator<Map.Entry<Address,ArrayList<NewUser>>>{
	@Override 
    public int compare(Map.Entry<Address,ArrayList<NewUser>> e1, Map.Entry<Address,ArrayList<NewUser>> e2) {
        int res = e2.getValue().size() - e1.getValue().size();
        if(res == 0) {
        	if(e1.getKey().zipcode.equals(e2.getKey().zipcode)) 
        		return e1.getKey().city.compareTo(e2.getKey().city);
        	else
        		return e1.getKey().zipcode.compareTo(e2.getKey().zipcode);
        }
        return res;
    }

}
