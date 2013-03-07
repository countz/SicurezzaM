import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;


public class TripleDES {
	
	public static void main(String[] args)
	{
		String text = "Hello world!";
		try {
			KeyGenerator keygen = KeyGenerator.getInstance("TripleDES");
			keygen.init(168);
			
			Key key = keygen.generateKey();
			
			try {
				Cipher cipher = Cipher.getInstance("TripleDES/ECB/PKCS5Padding");
				try {
					cipher.init(Cipher.ENCRYPT_MODE, key);
					
					try {
						byte[] plaintext = text.getBytes("UTF8");
						System.out.println("Plain text:");
						for (int i=0; i<plaintext.length; i++)
							System.out.print(plaintext[i]+" ");
						
						try {
							byte[] ciphertext = cipher.doFinal(plaintext);
							System.out.println("\nCipher text:");
							for (int i=0; i<ciphertext.length; i++)
								System.out.print(ciphertext[i]+" ");
							
							cipher.init(Cipher.DECRYPT_MODE, key);
							
							byte[] decryptedText = cipher.doFinal(ciphertext);
							String output = new String(decryptedText, "UTF8");
							System.out.println("\nDecrypted Text: " +output);
							
						} catch (IllegalBlockSizeException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (BadPaddingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} catch (InvalidKeyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
