package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
    private static final String ALGORITHM = "MD5";

    /**
     * Encrypt the specified text using {@value ALGORITHM} algorithm.
     *
     * @param text the text that should be encrypted.
     * @return the encrypted ciphertext.
     */
    public static String encrypt(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
            digest.update(text.getBytes());
            BigInteger cipher = new BigInteger(digest.digest());
            return cipher.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException();
    }
}
