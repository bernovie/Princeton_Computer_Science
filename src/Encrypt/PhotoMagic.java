package Encrypt;
import java.util.Scanner;
import java.awt.*;
import java.lang.System.*;
import javax.swing.JFrame;

public class PhotoMagic extends JFrame {
	public PhotoMagic(){
	
	}
	public static int [][] transform(int [][] picture,String seed,int tap){
		LFSR2.init(seed, tap);
			for(int y = 0; y < picture.length; y++){
				for(int x = 0; x < picture[0].length; x++){					
					picture [y][x] = picture [y][x]^LFSR2.generate(32); 
				}
			}
			ImageData.show(picture);
			ImageData.save(picture,"/Users/berny/Desktop/encrypted");
		int [][] a = {};
		return a;		
	}
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		PhotoMagic run = new PhotoMagic();
		System.out.println("Enter the adress of the image: ");
		String imageAddress = in.next();
		int [][] img = ImageData.imageData(imageAddress);
		run.transform(img,"01101000010", 8);
		run.setVisible(true);
		run.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
