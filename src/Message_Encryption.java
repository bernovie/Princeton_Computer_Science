import java.util.Scanner;
import java.util.Base64;
import java.nio.charset.Charset;

public class Message_Encryption {

	
	public static void main(String [] args){
		LFSR run = new LFSR();
		Scanner in = new Scanner(System.in);
		boolean[] binary = new boolean[2047];	
		
		//Message
		System.out.println("Enter the message: ");
		String message = in.nextLine(); 
			
		System.out.print(message);
		System.out.print('\n');
		
		//Convert Message to base64
		byte[] bytes = message.getBytes();
		for(int i = 0; i < bytes.length; i++ ){
			System.out.print(bytes[i]);
		}
		System.out.print("\n");
		
		String encoded = Base64.getEncoder().encodeToString(bytes);
		System.out.print(encoded);
		System.out.print("\n");
		
		
		byte[] base64 = Base64.getDecoder().decode(encoded);
		for(int i = 0; i < base64.length; i++ ){
			String bin = Integer.toBinaryString(base64[i]);
			
			if(bin.length() < 8){
				bin = "0" + bin;
			}
			char[] array = bin.toCharArray();
			
			if(array[i] == '1'){
				binary[i] = true;
			}
			else {
				binary[i] = false;
			}
			System.out.println(bin);
		}
		for( int i = 0; i < 8; i++){
			System.out.print(binary[i]);
		}
			System.out.print("\n");
			
		
		System.out.print("\n");
		//Decrypted Message
		String decoded = new String(base64);
		System.out.print(decoded);
		System.out.print("\n");
		
        // initial fill
        boolean[] a = { false, true, false, false, false,
                        false, true, false, true, true, false
                      };
        System.out.print("Enter the number of Steps: ");
        int T = in.nextInt();    			  // number of steps
        int N = a.length;                     // length of register
        int TAP = 8;                          // tap position


        // Simulate operation of shift register.
        for (int t = 0; t < T; t++) {

           // Simulate one shift-register step.
           boolean next = (a[N-1] ^ a[TAP]);  // Compute next bit.

           for (int i = N-1; i > 0; i--){
              a[i] = a[i-1];                  // Shift one position.
              if (a[i]) System.out.print("1");
    	      else System.out.print("0");
           }
           a[0] = next;                       // Put next bit on right end.
           if (a[0]) System.out.print("1");
 	       else System.out.print("0");
           System.out.print("\n");
         }
        System.out.println();    
		
	}
}
