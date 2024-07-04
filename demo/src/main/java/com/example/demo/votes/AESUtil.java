package com.example.demo.votes;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/GCM/NoPadding";
    private static final int GCM_TAG_LENGTH = 16;
    private static final int GCM_IV_LENGTH = 12;

    private static final byte[] key = "mySuperSecretKey".getBytes(); // 16-byte key

    public static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKeySpec keySpec = new SecretKeySpec(key, ALGORITHM);
        byte[] iv = new byte[GCM_IV_LENGTH];
        KeyGenerator.getInstance("AES").generateKey().getEncoded();
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * Byte.SIZE, iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        byte[] encryptedIvAndData = new byte[GCM_IV_LENGTH + encryptedData.length];
        System.arraycopy(iv, 0, encryptedIvAndData, 0, GCM_IV_LENGTH);
        System.arraycopy(encryptedData, 0, encryptedIvAndData, GCM_IV_LENGTH, encryptedData.length);
        return Base64.getEncoder().encodeToString(encryptedIvAndData);
    }

    public static String decrypt(String encryptedData) throws Exception {
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKeySpec keySpec = new SecretKeySpec(key, ALGORITHM);
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * Byte.SIZE, decodedData, 0, GCM_IV_LENGTH);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);
        byte[] originalData = cipher.doFinal(decodedData, GCM_IV_LENGTH, decodedData.length - GCM_IV_LENGTH);
        return new String(originalData);
    }
}
