package Encrypt;

import java.lang.System;

public class LFSR2 {
	private static char[] seedArray = new char[2047];
	private static int tapPosition = 0;
	private static int N = 0,bitTotal = 0;
	private static String register = "";
	
	public static boolean init(String seed,int tap){
		int contador = 0;
		if(tap >= seed.length()){
			return false;
		}
		else {
			tapPosition = tap;
		}
		for (int i = seed.length()-1; i >= 0; i--){
			if(seed.charAt(i) == '0'|| seed.charAt(i) == '1'){
				seedArray [i] = seed.charAt(contador);				
			}
			else {
				tapPosition = 0;
				return false;
			}
			contador++;
		}
		N = seed.length();
		return true;
	}
	
	public static char step(){
		// Simulate one shift-register step.
	    int next = (seedArray[N-1] ^ seedArray[tapPosition]);  // Compute next bit.
	    for (int i = N-1; i > 0; i--){
	    	seedArray[i] = seedArray[i-1];                  // Shift one position.
	    }
	    seedArray[0] = (char) (next + '0');                       // Put next bit on right end.
		return seedArray[0];
	}
	
	public static int generate(int k){
		bitTotal = 0;
		for (int  i = 1; i <= k; i++){
			int val = 0;
			if( step() == '1')
				val = 1;
			
			bitTotal = (bitTotal*2) + val;
		}
		return bitTotal;
	}
	
	public static String string(){
		register = "";
		for(int i = N-1; i >= 0; i--){
			System.out.print(seedArray[i]);
		}
		return register;
	}
	public static void main(String [] args){
		LFSR2 run = new LFSR2();
		LFSR2.init("01101000010", 8);
		for (int i = 0; i < 10; i++) {
		    int r = LFSR2.generate(5);
		    System.out.print(LFSR2.string() + " " + r + "\n");
		}
		System.out.print(25^3);
	}
}
