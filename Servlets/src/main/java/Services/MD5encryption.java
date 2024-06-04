package Services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class MD5encryption {


    //Create random salt
    public static  byte[] createMineral(){
        byte[] bytes = new byte[20];
        SecureRandom salt = new SecureRandom(); //get a secure random salt
        salt.nextBytes(bytes);
        return  bytes;
    }


    //GET THE SALTED HASH
    public static String getHashMD5(String unhashed, String salt) {
        // Hash the password.
        final String toHash = salt + unhashed +"!@%^"+ salt;

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            return "00000000000000000000000000000000";
        }
        messageDigest.update(toHash.getBytes(), 0, toHash.length());
        String hashed = new BigInteger(1, messageDigest.digest()).toString(16);
        if (hashed.length() < 32) {
            hashed = "0" + hashed;
        }
        return hashed.toUpperCase();
    }

}