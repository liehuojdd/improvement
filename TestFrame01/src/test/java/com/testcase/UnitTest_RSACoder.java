package com.testcase;

import static org.junit.Assert.*;  

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.util.RSACoder;  
  
/** 
 *  
 */  
public class UnitTest_RSACoder {  
    private String publicKey;  
    private String privateKey;  
  
    @BeforeClass  
    public void setUp() throws Exception {  
        Map<String, Object> keyMap = RSACoder.initKey();  
  
        publicKey = RSACoder.getPublicKey(keyMap);
        //publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC8aVkXsKNoRwiEBikamRvgLycK6N7fgx5VlliW" + 
        //		"V6yyXbUOLdgTjCsX2jWPMoR95IJDlT+STevdksTOBYz0FC69gTbpzqWVuxOFZ9aFFT4FSgOVSXO4" + 
        //		"kfWb+jqYpyhE4eSo8JRUY0g0vnRBjMosYPaBRV8Rg11+p6KJxyWzYdX5LQIDAQAB";
        privateKey = RSACoder.getPrivateKey(keyMap);
        System.err.println("public key: \n\r" + publicKey);  
        System.err.println("private key: \n\r" + privateKey);  
    }  
  
    @Test  
    public void test() throws Exception {  
        System.err.println("Encode public key->Decode private key");  
        String inputStr = "abc";  
        byte[] data = inputStr.getBytes();  
  
        byte[] encodedData = RSACoder.encryptByPublicKey(data, publicKey);  
  
        byte[] decodedData = RSACoder.decryptByPrivateKey(encodedData, privateKey);  
  
        String outputStr = new String(decodedData);  
        System.err.println("Before encode: " + inputStr + "\n\r" + "After decode: " + outputStr);  
        assertEquals(inputStr, outputStr);  
  
    }  
  
    @Test  
    public void testSign() throws Exception {  
        System.err.println("Encode private key->Deocde public key");  
        String inputStr = "sign";  
        byte[] data = inputStr.getBytes();  
  
        byte[] encodedData = RSACoder.encryptByPrivateKey(data, privateKey);  
  
        byte[] decodedData = RSACoder.decryptByPublicKey(encodedData, publicKey);  
  
        String outputStr = new String(decodedData);  
        System.err.println("Before encode: " + inputStr + "\n\r" + "After decode: " + outputStr);  
        assertEquals(inputStr, outputStr);  
  
        System.err.println("Private sign, public key verify");  
        // Generate sign
        String sign = RSACoder.sign(encodedData, privateKey);  
        System.err.println("Sign:\r" + sign);  
  
        // Verify sign  
        boolean status = RSACoder.verify(encodedData, publicKey, sign);  
        System.err.println("Status:\r" + status);  
        assertTrue(status);  
  
    }  
  
}  