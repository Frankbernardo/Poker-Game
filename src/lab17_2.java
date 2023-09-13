import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class lab17_2 {

	public static void main(String[] args) {
		try(DataOutputStream output = new DataOutputStream(new FileOutputStream("lab17_2.dat"))){
			output.writeUTF("Thursday");
			output.writeInt(1);
			
			output.writeUTF("Friday");
			output.writeInt(2);
			
			output.writeUTF("Saturday");
			output.writeInt(3);
			
			output.writeUTF("Sunday");
			output.writeInt(4);
			
			output.writeUTF("Monday");
			output.writeInt(5);
			
			output.writeUTF("Tuesday");
			output.writeInt(6);
			
			output.writeUTF("Wedensday");
			output.writeInt(7);
			
			
			
		}catch(IOException ex) {
		System.out.println("IO error");
			
		}
		
		try(DataInputStream input = new DataInputStream(new FileInputStream("lab17_2.dat"))){
			
			for(int i=0; i<7; i++) {
				System.out.println(input.readUTF() + " " + input.readInt());
			}
			
		}catch(EOFException ex) {
			System.out.println("end of file");
		}
		
		catch(IOException ex) {
		System.out.println("IO error");

}
	}
}
