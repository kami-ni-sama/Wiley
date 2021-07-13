package wiley.training.advanced.day6;
import java.util.*;
public class ThreadFibonacci implements Runnable {
	private int x;
	public  int answer;
	public static Map<List<Integer>, Integer> fib = new LinkedHashMap<>();
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

	{
		try {

			for (int i=0;i<5;i++){
				ThreadFibonacci f= new ThreadFibonacci(i);
				Thread threadf= new Thread(f);
				threadf.start();
				threadf.join();
//				System.out.println(":"+f.answer);

			}
			for(Map.Entry<List<Integer>, Integer> m:ThreadFibonacci.fib.entrySet()) {
				System.out.println(m.getKey()+" "+m.getValue());
			}
		}

		catch(Exception e) {
			System.out.println("usage: java Fib NUMBER");
		}
	}
}