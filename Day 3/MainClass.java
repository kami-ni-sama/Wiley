package wiley.training.advanced.day3;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = Arrays.asList(6, 7, 8, 9, 10, 1, 2, 3, 4, 5);
		List<Integer> evenNums = new ArrayList<>();
		for(int i: nums)
			if(i%2 == 0)
				evenNums.add(i);
		Stream<Integer> integerStream = nums.stream();
		Stream<Integer> streamOfEvenNums = nums.stream().filter(new FilterEvenNums());
		streamOfEvenNums.collect(Collectors.toList()).forEach(i->new EvenConsumer());
		
//		List<Integer> evenList = nums.stream().filter(n-> n%2 == 0).collect(Collectors.toList());
		
		nums
			.stream()
			.filter(n->n%2==0)
			.sorted((i, j)->i-j)
			.forEach(n-> System.out.println("Even consumer: "+n));
		
		List<String> messages = Arrays.asList("10", "20", "33", "45", "69");
		
		List<Integer> msgNum = messages
			.stream().
			filter(s -> s.endsWith("0"))
			.map(i -> new Integer(i)).collect(Collectors.toList());
			//.forEach(s->System.out.println(s));
		
		List<UserNew> users = Arrays.asList(
				new UserNew(1, "User 1"),
				new UserNew(2, "User 2"),
				new UserNew(3, "User 3"));
		
		List<EmployeeNew> employees = users
			.stream()
			.map(user -> new EmployeeNew(user.id, user.name))
			.collect(Collectors.toList());
			//.forEach(e->System.out.println(e.id+e.name));
		
	}

}

class MyComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1 - o2;
	}
	
}

class FilterEvenNums implements Predicate<Integer>{

	@Override
	public boolean test(Integer t) {
		if(t%2 == 0)
			return true;
		else
			return false;
	}
	
}

class EvenConsumer implements Consumer<Integer>{

	@Override
	public void accept(Integer t) {
		System.out.println("Even Consumer: "+t);
		
	}
	
}

class UserNew{
	int id;
	String name;
	public UserNew(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
}

class EmployeeNew{
	int id;
	String name;
	public EmployeeNew(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
}
