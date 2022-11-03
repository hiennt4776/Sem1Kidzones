package Encrypt;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author nguyenquang
 */
public class Encrypt_MD5 {
   
    public static String encrypt(String srcText) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        String enrText = null;
        
        MessageDigest msd = MessageDigest.getInstance("MD5");
        byte[] srcTextBytes = srcText.getBytes("UTF-8");
        byte[] enrTextBytes = msd.digest(srcTextBytes);
        BigInteger bigInteger = new BigInteger(1, enrTextBytes);
        enrText = bigInteger.toString(16);
        return enrText;
    } 


    
}