package com.linkcar.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 对字符串加密,加密算法使用MD5,SHA-1,SHA-256,默认使用SHA-256
 */
public class EncryptUtil {
    private final static String SHA256 = "SHA-256";

    /**
     * @param strSrc  要加密的字符串
     * @param encName 加密类型
     * @return
     */
    public static String Encrypt(String strSrc, String encName) {
        MessageDigest md = null;
        String strDes = null;
        byte[] bt = strSrc.getBytes();
        if (encName == null || encName.equals("")) {
            encName = SHA256;
        }
        try {
            md = MessageDigest.getInstance(encName);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        md.update(bt);
        strDes = bytes2Hex(md.digest()); // to HexString	
        return strDes;
    }

    /**
     * 直接使用sha256散列
     *
     * @param strSrc 要加密的字符串
     * @return
     */
    public static String EncryptSHA256(String strSrc) {
        return Encrypt(strSrc, SHA256);
    }

    private static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }

    public static void main(String args[]) {
        String s = EncryptUtil.EncryptSHA256("Geksisioe12312");
        System.out.println(s);
    }
}	
