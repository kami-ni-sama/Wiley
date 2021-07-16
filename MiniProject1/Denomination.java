package wiley.training.advanced.miniproject1;

import java.util.Scanner;

public class Denomination {
	static double[] arr = new double[]{10, 10, 10, 10, 10, 10};
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    	
    	double[] newArr = new double[] {0, 0, 0, 0, 0, 0};
        double orgAmount; 
        long thousands = 0, fiveHundreds = 0, hundreds = 0, fifties = 0, twenties = 0, tens = 0;
        
        orgAmount = sc.nextDouble();
        
        while(orgAmount>0) {
        	
        	thousands = (long )orgAmount / 1000L;
        	
        	
        	
//        	thousands = (long )orgAmount / 1000L;
//        	if(thousands<arr[0]) {
//        		orgAmount = orgAmount % 1000L;
//        		arr[0]-=thousands;
//        	}
        	System.out.printf("Available 1000 Rs notes %f\n", arr[0]);
        	System.out.printf("Number of 1000 Rs notes: %d\n", thousands);
        	System.out.println(orgAmount);

        	fiveHundreds = (long )orgAmount / 500L;
        	if(fiveHundreds<arr[1]) {
        		orgAmount = orgAmount % 500L;
        		arr[1]-=fiveHundreds;
        	}
        	System.out.printf("Available 500 Rs notes %f\n", arr[1]);
        	System.out.printf("Number of 500 Rs notes: %d\n", fiveHundreds);
        	System.out.println(orgAmount);

        	hundreds = (long )orgAmount / 100L;
        	if(hundreds<arr[2]) {
        		orgAmount = orgAmount % 100L;
        		arr[2]-=hundreds;
        	}
        	System.out.printf("Available 100 Rs notes %f\n", arr[2]);
        	System.out.printf("Number of 100 Rs notes: %d\n", hundreds);
        	System.out.println(orgAmount);

        	fifties = (long )orgAmount / 50L;
        	if(fifties<arr[3]) {
        		orgAmount = orgAmount % 50L;
        		arr[3]-=fifties;
        	}
        	System.out.printf("Available 50 Rs notes %f\n", arr[3]);
        	System.out.printf("Number of 50 Rs notes: %d\n",fifties);
        	System.out.println(orgAmount);

        	twenties = (long )orgAmount / 20L;
        	if(twenties<arr[4]) {
        		orgAmount = orgAmount % 20L;
        		arr[4]-=twenties;
        	}
        	System.out.printf("Available 20 Rs notes %f\n", arr[4]);
        	System.out.printf("Number of 20 Rs notes: %d\n", twenties);
        	System.out.println(orgAmount);

        	tens = (long )orgAmount / 10L;
        	if(tens<arr[5]) {
        		orgAmount = orgAmount % 10L;
        		arr[5]-=tens;
        	}
        	System.out.printf("Available 10 Rs notes %f\n", arr[5]);
        	System.out.printf("Number of 10 Rs notes: %d\n", tens);
        	System.out.println(orgAmount);
        }
    }
    
//    double checkRest(double amount, int index) {
//    	double sum = 0;
//    	for(int i = index; i<arr.length; i++) {
//    		sum+= 
//    	}
//    }

}



/*
 * 
 * 
 * 
 */






