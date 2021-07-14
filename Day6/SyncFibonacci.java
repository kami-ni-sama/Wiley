package wiley.training.advanced.day6;

import java.util.*;

public class SyncFibonacci {

	public static void main(String[] args) {
		List<Integer> fib = new ArrayList<Integer>();
		int n = 10;
		SyncFibonacciWriter write = new SyncFibonacciWriter(fib, n);
		SyncFibonacciReader read = new SyncFibonacciReader(fib, n);
		Thread writer = new Thread(write, "Writer");
		Thread reader = new Thread(read, "Reader");
		writer.start();
		reader.start();
	}

}

class SyncFibonacciWriter implements Runnable{
	private List<Integer> arr;
	private int n;
	int a = 0, b = 1, c=0;
	{
		arr = new ArrayList<Integer>();
		arr.add(a);
		arr.add(b);
	}
	
	public SyncFibonacciWriter(List<Integer> arr, int n){
		this.arr = arr;
		this.n = n;
	}
	
	@Override
	public void run() {
		while(n>0) {
			try {
				add(a, b, n);
			}catch (InterruptedException ex){
                ex.printStackTrace();
            }
		}
		
	}
	
	void add(int a, int b, int n) throws InterruptedException {
		synchronized (arr) {
			while(arr.size()!=n) {
				c = a+b;
				arr.add(c);
				System.out.println("Added "+c+" to the list using "+Thread.currentThread().getName());
//				System.out.println(a+" "+b+" "+c);
				a = b;
				b = c;
				Thread.sleep(1000);
				arr.notify();
			}
			
		}
	}
	
}

class SyncFibonacciReader implements Runnable{
	private List<Integer> arr;
	private int n;
	
	public SyncFibonacciReader(List<Integer> arr, int n){
		this.arr = arr;
		this.n = n;
	}
	
	@Override
	public void run() {
		
			try {
				read(n);
			}catch (InterruptedException ex){
                ex.printStackTrace();
            }
		
	}
	
	void read(int n) throws InterruptedException {
		synchronized (arr) {
			Thread.sleep(1000);
			for(int i = 0; i < n-2; i++) {
				System.out.println(arr.get(i)+" + "+arr.get(i+1)+" = "+arr.get(i+2));
			}
			arr.notify();
			
		}
	}
	
}

/*
Output: 
Added 1 to the list using Writer
Added 2 to the list using Writer
Added 3 to the list using Writer
Added 5 to the list using Writer
Added 8 to the list using Writer
Added 13 to the list using Writer
Added 21 to the list using Writer
Added 34 to the list using Writer
Added 55 to the list using Writer
Added 89 to the list using Writer
1 + 2 = 3
2 + 3 = 5
3 + 5 = 8
5 + 8 = 13
8 + 13 = 21
13 + 21 = 34
21 + 34 = 55
34 + 55 = 89

*** The program doesn't terminate after this

*/