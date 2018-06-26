package com.agentpay.common;


import java.security.MessageDigest;

import static com.sun.javafx.font.FontResource.SALT;

public class EncryptHelper {

    private static final String ENCODE_AES = "springbootTraining";
    //md5
    public static String Md5Util(String str) {
        str = str + SALT;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        char[] charArray = str.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }

            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    //aes加密
    public static String aesEncrypt(String password, String aesKey, String aesIv) {
        return "";
    }

    //aes解密
    public static String aesDecrypt(String str, String aesKey, String aesIv) {
        return "";
    }

}
