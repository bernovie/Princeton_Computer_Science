import java.util.Scanner;

/******************************************************************************
 *  Compilation:  javac LFSR.java
 *  Execution:    java LFSR N
 *  
 *  Simulate a LFSR for N steps and print results.
 *
 *  % java LFSR 40
 *  1100100100111101101110010110101110011000
 *
 ******************************************************************************/


public class LFSR {
    public static void main(String[] args) { 
    	Scanner in = new Scanner(System.in);
    	
        // initial fill
        boolean[] a = { false, true, true, false, true,
                        false, false, false, false, true, false
                      };
        System.out.print("Enter the number of Steps: ");
        int T = in.nextInt();    			  // number of steps
        int N = a.length;                     // length of register
        int TAP = 2;                          // tap position


        // Simulate operation of shift register.
        for (int t = 0; t < T; t++) {

           // Simulate one shift-register step.
           boolean next = (a[0] ^ a[TAP]);  // Compute next bit.

           for (int i = 0; i < N-1; i++){
              a[i] = a[i+1];                  // Shift one position.
              if (a[i]) System.out.print("1");
    	      else System.out.print("0");
           }
           a[N-1] = next;                       // Put next bit on right end.
           if (a[N-1]) System.out.print("1");
 	       else System.out.print("0");
           System.out.print("\n");
         }
        System.out.println();    
    }
}


