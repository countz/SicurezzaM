import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SHA2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			String filename;
			if(args.length == 1)
			{
				filename = args[0];
				FileInputStream fis = new FileInputStream(filename);
				
				byte[] dataBytes = new byte[1024];
				 
		        int nread = 0;
		        while ((nread = fis.read(dataBytes)) != -1) {
		          md.update(dataBytes, 0, nread);
		        };
		        
		        byte[] mdbytes = md.digest();
		        
		        StringBuilder sb = new StringBuilder();
		        for (byte b : mdbytes) {
		            sb.append(String.format("%02X ", b));
		        }
		        System.out.println("File name: " +filename);
		        System.out.println("Digest SHA-256: " +sb.toString());
			
			}
			
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
