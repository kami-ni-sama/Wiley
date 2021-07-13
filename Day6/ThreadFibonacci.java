package wiley.training.advanced.day6;
import java.util.*;
public class ThreadFibonacci implements Runnable {
	private int x;
	public  int answer;
	public static Map<List<Integer>, Integer> fib = new LinkedHashMap<>();
	{
		ThreadFibonacci.fib.put(Arrays.asList(0, 1), 1);
	}
	
	public ThreadFibonacci(int x) {
		this.x = x;
	}

	public void run() {
		if( x < 2 )
			answer = 1;
		else {
			try {
				ThreadFibonacci f1= new ThreadFibonacci(x-1);
				ThreadFibonacci f2= new ThreadFibonacci(x-2);
				Thread threadf1=new Thread(f1);
				Thread threadf2=new Thread(f2);
				threadf1.start();
				threadf2.start();
				threadf1.join();
				threadf2.join();
				answer = f1.answer + f2.answer;
				fib.put(Arrays.asList(f2.answer, f1.answer), answer);
			}
			catch(InterruptedException ex) { }
		}
	}

	public static void main(String[] args)

	{	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number of output lines: ");
		int n = sc.nextInt();
		try {

			for (int i=1;i<=n;i++){
				ThreadFibonacci f= new ThreadFibonacci(i);
				Thread threadf= new Thread(f);
				threadf.start();
				threadf.join();
//				System.out.println(":"+f.answer);

			}
			for(Map.Entry<List<Integer>, Integer> m:ThreadFibonacci.fib.entrySet()) {
				System.out.println(m.getKey().get(0)+" + "+m.getKey().get(1)+" = "+m.getValue());
			}
		}

		catch(Exception e) {
			System.out.println("usage: java Fib NUMBER");
		}
	}
}