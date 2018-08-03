import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

// TODO: Implement 256-bit version like: http://securejava.wordpress.com/2012/10/25/aes-256/
public class AESUtils {
    private final int keySize;
    private final int iterationCount;
    private final Cipher cipher;

    public AESUtils(int keySize, int iterationCount) {
        this.keySize = keySize;
        this.iterationCount = iterationCount;
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw fail(e);
        }
    }

    public String encrypt(String salt, String iv, String passphrase, String plaintext) {
        try {
            SecretKey key = generateKey(salt, passphrase);
            byte[] encrypted = doFinal(Cipher.ENCRYPT_MODE, key, iv, plaintext.getBytes("UTF-8"));
            return base64(encrypted);
        }
        catch (UnsupportedEncodingException e) {
            throw fail(e);
        }
    }

    public String decrypt(String salt, String iv, String passphrase, String ciphertext) {
        try {
            SecretKey key = generateKey(salt, passphrase);
            byte[] decrypted = doFinal(Cipher.DECRYPT_MODE, key, iv, base64(ciphertext));
            return new String(decrypted, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            throw fail(e);
        }
    }

    private byte[] doFinal(int encryptMode, SecretKey key, String iv, byte[] bytes) {
        try {
            cipher.init(encryptMode, key, new IvParameterSpec(hex(iv)));
            return cipher.doFinal(bytes);
        }
        catch (InvalidKeyException
                | InvalidAlgorithmParameterException
                | IllegalBlockSizeException
                | BadPaddingException e) {
            throw fail(e);
        }
    }

    private SecretKey generateKey(String salt, String passphrase) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), hex(salt), iterationCount, keySize);
            SecretKey key = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
            return key;
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw fail(e);
        }
    }

    public static String random(int length) {
        byte[] salt = new byte[length];
        new SecureRandom().nextBytes(salt);
        return hex(salt);
    }

    public static String base64(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    public static byte[] base64(String str) {
        return Base64.decodeBase64(str);
    }

    public static String hex(byte[] bytes) {
        return Hex.encodeHexString(bytes);
    }

    public static byte[] hex(String str) {
        try {
            return Hex.decodeHex(str.toCharArray());
        }
        catch (DecoderException e) {
            throw new IllegalStateException(e);
        }
    }

    private IllegalStateException fail(Exception e) {
        return new IllegalStateException(e);
    }

    public static void main(String[] args) {
//        AESUtils aesUtil = new AESUtils(32, 10000);
//        String plaintext = aesUtil.decrypt(salt, iv, 'passphrase', 'plainText');
        System.out.println(AESUtils.encrypt("ZDY0OTc1Yzg2MTYyZTc1ODk5NmJlYzc3MzFkMDY4MzI6OmMzMzNhYmUxYWI1NjY3YjFkMTFhMGJiMjVjZjVkZmQyOjpzdWdRc3ZCVnZsSVBNN3FxL0Zvbk50cW1RQ1pacVQvWCtUb3dyeDhZNTFrbFRLaHJkbmNVVXZhYnlCN0tZRTFSdWVWbEpKUjZ4ZmdlQUdLWnh3NjJLSW1vSHIwK1IvTXcycmdmZEs4M2szS2hhR1pHbWgrWSszT0ZZUXdXQTI4bFhjQ09teGkvSDFhSXQ3c1hRdDkvMjYvT3RLM3pMaEY1djlBUzNRS3hScjQ9="));
    }

    public static String encrypt(String plainText) {

        String decryptedPassword = new String(java.util.Base64.getDecoder().decode(plainText));
        AESUtils aesUtil = new AESUtils(128, 1000);
        String password = "fail";

        if (decryptedPassword != null && decryptedPassword.split("::").length == 3) {

             password = aesUtil.decrypt(decryptedPassword.split("::")[1], decryptedPassword.split("::")[0], "1234567891234567", decryptedPassword.split("::")[2]);
        }
        return password;
    }

    private static Key generateKey() throws Exception {
        final byte[] keyValue = "1234567890123456".getBytes(Charset.forName("UTF-8"));
        Key key = new SecretKeySpec(keyValue, "AES");
        return key;
    }
}