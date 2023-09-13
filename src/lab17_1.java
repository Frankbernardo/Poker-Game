import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class lab17_1 {

	public static void main(String[] args) {
		try {
			FileOutputStream output = new FileOutputStream("lab17_1.dat");
			
			for(int i=1; i<=20; i++) {
				output.write(i);
			}
			
			output.close();
			
		}catch(FileNotFoundException ex) {
			System.out.println("file not found");
			
		}catch(IOException ex) {
			System.out.println("IO error");
			
		}
		
		//open usingauto close
		//opening in append mode
		try(FileOutputStream output = new FileOutputStream("lab17_1.dat", true)) {
			
			for(int i=21; i<=40; i++) {
				output.write(i);
			}
			
		}catch(FileNotFoundException ex) {
			System.out.println("file not found");
			
		}catch(IOException ex) {
			System.out.println("IO error");
			
		}
		
		try(FileInputStream input = new FileInputStream("lab17_1.dat")) {
			int[] values = new int[40];
			
			for(int i=0; i<40; i++) 
				values[i] = input.read();
			for(int i=values.length -1; i>=0; i--) {
				System.out.println(values[i]);
			}
			
			
		}catch(IOException ex) {
		System.out.println("IO error");
			
		}
 
	}

}
