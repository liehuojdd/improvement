package com.util;

import java.security.Key;  
import java.security.KeyFactory;  
import java.security.KeyPair;  
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;  
import java.security.PublicKey;  
import java.security.Signature;  
import java.security.interfaces.RSAPrivateKey;  
import java.security.interfaces.RSAPublicKey;  
import java.security.spec.PKCS8EncodedKeySpec;  
import java.security.spec.X509EncodedKeySpec;  
  
import java.util.HashMap;  
import java.util.Map;  
  
import javax.crypto.Cipher;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;  
  
/** 
 * RSA Security
 *  
 */  
public abstract class RSACoder{  
    public static final String KEY_ALGORITHM = "RSA";  
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";  
  
    private static final String PUBLIC_KEY = "RSAPublicKey";  
    private static final String PRIVATE_KEY = "RSAPrivateKey";  
  
    /** 
     * Generate singnature with private key
     */  
    public static String sign(byte[] data, String privateKey) throws Exception {  
        // decode private key 
        byte[] keyBytes = decryptBASE64(privateKey);  
  
        // Constructor of PKCS8EncodedKeySpec
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);  
  
        // KEY_ALGORITHM
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
  
        // Get private key
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);  
  
        // Generate sign
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);  
        signature.initSign(priKey);  
        signature.update(data);  
  
        return encryptBASE64(signature.sign());  
    }  
  
    /** 
     * Verify sign 
     */  
    public static boolean verify(byte[] data, String publicKey, String sign)  
            throws Exception {  

        byte[] keyBytes = decryptBASE64(publicKey);  
  
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);  

        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
  
        PublicKey pubKey = keyFactory.generatePublic(keySpec);  
  
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);  
        signature.initVerify(pubKey);  
        signature.update(data);  
  
        return signature.verify(decryptBASE64(sign));  
    }  
  
    /** 
     * Decode with private key
     */  
    public static byte[] decryptByPrivateKey(byte[] data, String key)  
            throws Exception {  

        byte[] keyBytes = decryptBASE64(key);  
  
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);  
  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.DECRYPT_MODE, privateKey);  
  
        return cipher.doFinal(data);  
    }  
  
    /** 
     * Decode with public key
     */  
    public static byte[] decryptByPublicKey(byte[] data, String key)  
            throws Exception {  
 
        byte[] keyBytes = decryptBASE64(key);  
  
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        Key publicKey = keyFactory.generatePublic(x509KeySpec);  
  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.DECRYPT_MODE, publicKey);  
  
        return cipher.doFinal(data);  
    }  
  
    /** 
     * Encode with public key
     */  
    public static byte[] encryptByPublicKey(byte[] data, String key)  
            throws Exception {  

        byte[] keyBytes = decryptBASE64(key);  
  
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        Key publicKey = keyFactory.generatePublic(x509KeySpec);  
  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);  
  
        return cipher.doFinal(data);  
    }  
  
    /** 
     * Encode with private key
     */  
    public static byte[] encryptByPrivateKey(byte[] data, String key)  
            throws Exception {  

        byte[] keyBytes = decryptBASE64(key);  
  
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);  
  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);  
  
        return cipher.doFinal(data);  
    }  
  
    /** 
     * Get private key
     */  
    public static String getPrivateKey(Map<String, Object> keyMap)  
            throws Exception {  
        Key key = (Key) keyMap.get(PRIVATE_KEY);  
  
        return encryptBASE64(key.getEncoded());  
    }  
  
    /** 
     * Get public key
     */  
    public static String getPublicKey(Map<String, Object> keyMap)  
            throws Exception {  
        Key key = (Key) keyMap.get(PUBLIC_KEY);  
  
        return encryptBASE64(key.getEncoded());  
    }  
  
    /** 
     * Init key
     */  
    public static Map<String, Object> initKey() throws Exception {  
        KeyPairGenerator keyPairGen = KeyPairGenerator  
                .getInstance(KEY_ALGORITHM);  
        keyPairGen.initialize(1024);  
  
        KeyPair keyPair = keyPairGen.generateKeyPair();  
   
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  
  
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();  
  
        Map<String, Object> keyMap = new HashMap<String, Object>(2);  
  
        keyMap.put(PUBLIC_KEY, publicKey);  
        keyMap.put(PRIVATE_KEY, privateKey);  
        return keyMap;  
    } 
    
    /** 
     * BASE64 decode
     *  
     */  
    public static byte[] decryptBASE64(String key) throws Exception {  
        return (new BASE64Decoder()).decodeBuffer(key);  
    }  
  
    /** 
     * BASE64 encode
     *  
     */  
    public static String encryptBASE64(byte[] key) throws Exception {  
        return (new BASE64Encoder()).encodeBuffer(key);  
    }
    /** 
     * SHA encode, 
     *  One-Way Encryption, no decode.
     * @param data 
     * @return 
     * @throws Exception 
     */  
    public static byte[] encryptSHA(byte[] data) throws Exception { 
    	final String KEY_SHA = "SHA";
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);  
        sha.update(data);  
  
        return sha.digest();  
  
    }
}  