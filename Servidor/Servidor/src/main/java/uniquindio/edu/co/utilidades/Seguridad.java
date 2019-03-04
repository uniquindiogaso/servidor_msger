package uniquindio.edu.co.utilidades;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Seguridad {

    /**
     * @see https://www.geeksforgeeks.org/sha-512-hash-in-java/
     * @param texto sin cifrar
     * @return cadena cifrada
     */
    public static String cifrarPws(String input) {
        try {
            // getInstance() method is called with algorithm SHA-512 
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            // digest() method is called 
            // to calculate message digest of the input string 
            // returned as array of byte 
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value 
            String textoCifrado = no.toString(16);

            // Add preceding 0s to make it 32 bit 
            while (textoCifrado.length() < 32) {
                textoCifrado = "0" + textoCifrado;
            }

            // return the HashText 
            return textoCifrado;
        } // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
