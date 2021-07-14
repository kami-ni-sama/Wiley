package wiley.training.advanced.day6;

import java.util.*;

public class SyncFibonacci {

	public static void main(String[] args) throws InterruptedException{
		List<Integer> fib = new ArrayList<Integer>();
		int n = 5;
		SyncFibonacciWriter write = new SyncFibonacciWriter(fib, n);
		SyncFibonacciReader read = new SyncFibonacciReader(fib, n);
		Thread writer = new Thread(write, "Writer");
		Thread reader = new Thread(read, "Reader");
		writer.start();
		reader.start();
		writer.join();
		reader.join();
//		writer.interrupt();
//		reader.interrupt();
		System.out.println("Printed Fibonacci");
	}

}

class SyncFibonacciWriter implements Runnable{
	private List<Integer> arr;
	private int n;
	int a = 0, b = 1, c=0;
//	{
//		arr = new ArrayList<Integer>();
//		arr.add(a);
//		arr.add(b);
//	}
	
	public SyncFibonacciWriter(List<Integer> arr, int n){
		this.arr = arr;
		arr.add(a);
		arr.add(b);
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
			System.out.println("Entering writer");
			try {
				while(arr.size()!=n) {
					c = a+b;
					arr.add(c);
					System.out.println("Added "+c+" to the list using "+Thread.currentThread().getName());
					//				System.out.println(a+" "+b+" "+c);
					a = b;
					b = c;
					Thread.sleep(500);
//					arr.notify();
					
					
				}
				Thread.currentThread().wait();
				Thread.currentThread().interrupt();
//				arr.wait();
			}catch(InterruptedException ex) {
				System.out.println(ex);
			}
//			Thread.sleep(500);
			
			
			
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
			System.out.println("Entering reader");
			Thread.sleep(500);
			for(int i = 0; i < n-2; i++) {
				System.out.println(arr.get(i)+" + "+arr.get(i+1)+" = "+arr.get(i+2));
			}
//			arr.notify();
//			Thread.sleep(500);
		}
		Thread.currentThread().wait();
		Thread.currentThread().interrupt();
		
		
		
//		Thread.currentThread().wait();
		
//		arr.wait();
//		System.exit(0);
		
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
Exception in thread "Writer" java.lang.IllegalMonitorStateException: current thread is not owner
	at java.base/java.lang.Object.wait(Native Method)
	at java.base/java.lang.Object.wait(Object.java:321)
	at javaIntroduction/wiley.training.advanced.day6.SyncFibonacciWriter.add(SyncFibonacci.java:68)
	at javaIntroduction/wiley.training.advanced.day6.SyncFibonacciWriter.run(SyncFibonacci.java:46)
	at java.base/java.lang.Thread.run(Thread.java:832)
0 + 1 = 1
1 + 1 = 2
1 + 2 = 3
2 + 3 = 5
3 + 5 = 8
Exception in thread "Reader" java.lang.IllegalMonitorStateException: current thread is not owner
	at java.base/java.lang.Object.wait(Native Method)
	at java.base/java.lang.Object.wait(Object.java:321)
	at javaIntroduction/wiley.training.advanced.day6.SyncFibonacciReader.read(SyncFibonacci.java:108)
	at javaIntroduction/wiley.training.advanced.day6.SyncFibonacciReader.run(SyncFibonacci.java:91)
	at java.base/java.lang.Thread.run(Thread.java:832)
5 + 8 = 13
8 + 13 = 21
13 + 21 = 34
Printed Fibonacci


*** Want to resume in the main thread after both the threads are interrupted.
*/