package wiley.training.advanced.day6;

import java.util.*;

public class MainClass extends Thread{

	public static void main(String[] args) {
		System.out.println("MainClass: "+Thread.currentThread().getName());
//		Thread thread2 = new Thread("MyThread2");
//		Thread thread1 = new Thread("MyThread1");
//		thread1.start();
//		thread2.setPriority(Thread.MAX_PRIORITY);
//		thread2.start();
//		System.out.println(thread1.getName()+" "+thread1.getId()+" "+thread1.getPriority());
//		System.out.println(thread2.getName()+" "+thread2.getId()+" "+thread2.getPriority());
//		UserService userService1 = new UserService();
//		UserService userService2 = new UserService();
//		userService1.setName("Userservice 1");
//		userService2.setName("Userservice 2");
//		userService1.start();
//		userService2.start();
		
//		MainClass thread1 = new MainClass();
//		MainClass thread2 = new MainClass();
//		thread1.run();
//		thread2.run();
//		Sort s = new Sort(arr);
//		s.setName("Sorting thread");
//		s.start();

        // CREATE THREADS USING RUNNABLE

        EmpService empService = new EmpService();

        Thread empThread1 = new Thread(empService);

        Thread empThread2 = new Thread(empService);

        // start the thread
        empThread1.start();
        empThread2.start();
        System.out.println("gg");
        for(Integer in: empService.getIntegers()) {
        	System.out.println(in);
        }
		
	}

	public static void multiThreadSort(int threads, int[] arr, int start, int stop) {
	    if (threads > 1) {
	        int midpoint = partition(arr, start, stop);
	        new Thread(){public void run() {
	              multiThreadSort(threads - 1, arr, start, midpoint);
	        }}.start();
	        new Thread(){public void run() {
	              multiThreadSort(threads - 1, arr, midpoint, stop);
	        }}.start();
	    }
	    else 
	        Arrays.sort(arr, start, stop);
	}
	
	public static int partition(int[] arr, int start, int stop) {
		int pivot = arr[stop];
		int i = start - 1;
	    for(int j = start; j <= stop - 1; j++)
	    {
	         
	        // If current element is smaller
	        // than the pivot
	        if (arr[j] < pivot)
	        {	
//	            new Thread() { public void run() {
//	            	i++;
//	            	swap(arr, i, j);
//	            }}.start();
	        	i++;
	        	swap(arr, i, j);
	        }
	    }
	    swap(arr, i + 1, stop);
	    return (i + 1);
	}
	
	static void swap(int[] arr, int i, int j)
	{
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	

}


/*
 * Ways to create threads in Java:
 * 1. Thread Class
 * 2. Runnable Interface
 * 3. Callable Interface - comes under the concurrent API
 * 4. Executor Service/Framework
 * 
 * 
 * Types of threads:
 * 1. Priority Threads - they have high priority and can manipulate the JVM from processing.
 * 2. Daemon Threads - they are low priority and can't prevent JVM from exiting, they are always running in the background.
 *
 *
 * Life Cycle of a Thread:
 * 1. New
 * 2. Runnable
 * 3. Waiting/Sleep
 * 4. Blocked
 * 5. Terminated
 * 
 */


class UserService extends Thread{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() + " ---- "+i);
        }
    }
}

class Sort extends Thread{
	
	int arr[] = new int[20];
	
	Sort(int[] arr){
		this.arr = arr;
	}
	
	@Override
	public void run() {
		
	}
	
	
}

class EmpService implements Runnable{

    private List<Integer> integers = Collections.emptyList();//synchronizedList(new ArrayList<Integer>());

    @Override
    public void run() {
        integers = new ArrayList<>();

        for (int i = 0; i < 20 ; i++) {
        	if(!integers.contains(i))
        		integers.add(i);
            try {
                Thread.sleep(100);
            }catch (InterruptedException inEx){
                System.err.println(inEx);
            }
           
            System.out.println(Thread.currentThread().getName() + " ---- "+integers.get(i)+" with size "+integers.size());
        }
        System.out.println("The final size of the array is"+integers.size());
    }

    public List<Integer> getIntegers() {
    	System.out.println("Entering the function");
        return integers;
    }
}
