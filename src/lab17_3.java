import java.io.IOException;
import java.io.RandomAccessFile;

public class lab17_3 {

	public static void main(String[] args) {
		try {
			RandomAccessFile inout = new RandomAccessFile("lab17_3.dat", "rw");
			//clear the file to destroy the old contents if it exsits 
			
			inout.setLength(0);
			
			//write ints to file
			for(int i=0;i<200; i++) {
				inout.writeInt(i);
			}
			
			//display the length
			System.out.println("current length is: " + inout.length());
			
			//get first number
			
			inout.seek(0);
			System.out.println("the first number is: " + inout.readInt());
			
			//get second number
			
			inout.seek(1*4);
			System.out.println("the second number is: " + inout.readInt());
			
			inout.seek(1*36);
			System.out.println("the tenth number is: " + inout.readInt());
			
			inout.seek(1*40);
			System.out.println("the eleventh number is: " + inout.readInt());
			
			//modify
			
			inout.seek(10*4);
			inout.writeInt(555);
			
			//append
			inout.seek(inout.length());
			inout.writeInt(999);
			
			//display new length
			System.out.println("the new length is: " + inout.length());
			
			inout.seek(1*40);
			System.out.println("the eleventh modified number is: " + inout.readInt());
			
		}catch(IOException ex) {
			System.out.println("file error");
		}
		

		

	}

}
