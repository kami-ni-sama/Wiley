package wiley.training.advanced.day6;

public class SyncMainClass {

	public static void main(String[] args) {
		Process process = new Process();
		Thread t1 = new Thread(process, "T1");
//		t1.setPriority(1);
		t1.start();
		
		Thread t2 = new Thread(process, "T2");
//		t2.setPriority(2);
		t2.start();
		
		Thread t3 = new Thread(process, "T3");
//		t3.setPriority(3);
		t3.start();
		
		Thread t4 = new Thread(process, "T4");
//		t4.setPriority(4);
		t4.start();

		Thread t5 = new Thread(process, "T5");
//		t5.setPriority(5);
		t5.start();

		Thread t6 = new Thread(process, "T6");
//		t6.setPriority(6);
		t6.start();


	}

}

class Process implements Runnable{
	private int counter = 0;
	public int getCounter() {
		return counter;
	}
	public synchronized void increment() {
//		try {
//			Thread.sleep(100);
//		}catch(InterruptedException inEx){
//			inEx.printStackTrace();
//		}
		counter++;
	}
	public void decrement() {
		counter--;
	}
	@Override
	public synchronized void run() {
		this.increment();
		System.out.println("I : "+Thread.currentThread().getName()+" "+this.getCounter());
		this.decrement();
		System.out.println("D : "+Thread.currentThread().getName()+" "+this.getCounter());
	}
	
}