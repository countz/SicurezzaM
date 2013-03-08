import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Digest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {



			if(args.length == 2)
			{
				if(args[0].equalsIgnoreCase("MD2") || args[0].equalsIgnoreCase("MD5") ||
						args[0].equalsIgnoreCase("SHA-1") || args[0].equalsIgnoreCase("SHA-256") ||
						args[0].equalsIgnoreCase("SHA-384") || args[0].equalsIgnoreCase("SHA-512") )
				{
					String algorithm = args[0];

					MessageDigest md = MessageDigest.getInstance(algorithm);
					String filename;
					filename = args[1];
					FileInputStream fis = new FileInputStream(filename);

					byte[] dataBytes = new byte[1024];

					int nread = 0;
					while ((nread = fis.read(dataBytes)) != -1) {
						md.update(dataBytes, 0, nread);
					};
					
					fis.close();

					byte[] mdbytes = md.digest();

					StringBuilder sb = new StringBuilder();
					for (byte b : mdbytes) {
						sb.append(String.format("%02X ", b));
					}
					System.out.println("File name: " +filename);
					System.out.println("Digest SHA-256: " +sb.toString());
				}

				else
				{
					System.out.println("Usage: java Digest [MD2|MD5|SHA-1|SHA-256|SHA-384|SHA-512] file");
					System.exit(0);
				}



			}
			else
			{
				System.out.println("Usage: java Digest [MD2|MD5|SHA-1|SHA-256|SHA-384|SHA-512] file");
				System.exit(0);
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
