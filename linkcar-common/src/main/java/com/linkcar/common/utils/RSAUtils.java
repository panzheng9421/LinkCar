package com.linkcar.common.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAUtils {


    private static final String PUBLIC_KEY_PASSWORD = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCpNE2MMr3H2uElnbRdMMxXMHemWkwf3g+JE/wE0iOAQ7+1KCqMHjz1BTeEV9dcqpRFAZIbmmZqLNeqLdYHkrjN2F8yo/3mtq4KDQ+u2sWvWUs30TNIQxdCx2yzo/M3aWuUYHc5/Qlvo/ggM2Dovhq+PYGJtw3fkDvnkev65lALnwIDAQAB";
    private static final String PRIVATE_KEY_PASSWORD = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKk0TYwyvcfa4SWdtF0wzFcwd6ZaTB/eD4kT/ATSI4BDv7UoKowePPUFN4RX11yqlEUBkhuaZmos16ot1geSuM3YXzKj/ea2rgoND67axa9ZSzfRM0hDF0LHbLOj8zdpa5Rgdzn9CW+j+CAzYOi+Gr49gYm3Dd+QO+eR6/rmUAufAgMBAAECgYAaZtDa2WgHcT3EUtE74UthJ2zkBh7usgWWjAm87tUfRHL7X2MULfuw97lr6xDtoqg0BES6DeOBGbIlGbXVxK0VIHO9N6mii1VE8/EK2Y3S4Ug90WrXy6qcbWt6l+tWxzjK93CqiXHTHUdqvk8ZCiJ692fPOtEXpKctfMYCYw+mMQJBANm4AhMy66KQaaGS5r087X2t5Bhr8w7VweMgUUjOXVG9Ey1FdJpNmYKnCY9aBxuNKVfkKU0IFSwLxiVrrunsMksCQQDG9I3CCfYynLF2gKrPdeuv+hOK5j6pGv+dQOsO12DprfL/7vr0xjyXtyCceHP0Rtt/Dh1oKXpWmVIkQ9XMLFd9AkAVu6aJYBXhfmTs+gsKbOCQISGZxnzWyEO4dmtmxyLNnAAkDsDa/lAKmL39j1ESUP8FhQMSa3IhmXNIHP2y4B8NAkEAvbSOPsj04kmaxV3mgS71brTLUZQ9h01hEnbGKz6e//KHVBZxYFhtilRpWglYt0GhJcM1sw5pwo0rT70G7UoSmQJAE1p2txJwoHeWrVfZ690Dk0naj6KvKCItnXZFO0yVCf3ewOxhavn2CyUMfNRY8AUy4FSqr4F8JR2HQZD2xJ+5Cg==";
    /**
     * 私钥 RSAUtils
     */
    private RSAPrivateKey privateKey;

    /**
     * 公钥
     */
    private RSAPublicKey publicKey;

//    /**	
//     * 字节数据转字符串专用集合	
//     */	
//    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',	
//            'f'};	

    /**
     * 获取私钥
     *
     * @return 当前的私钥对象
     */
    public RSAPrivateKey getPrivateKey() {
        return privateKey;
    }

    /**
     * 获取公钥
     *
     * @return 当前的公钥对象
     */
    public RSAPublicKey getPublicKey() {
        return publicKey;
    }

    /**
     * 随机生成密钥对
     */
    public void genKeyPair() {
        KeyPairGenerator keyPairGen = null;
        try {
            keyPairGen = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        keyPairGen.initialize(1024, new SecureRandom());
        KeyPair keyPair = keyPairGen.generateKeyPair();
        this.privateKey = (RSAPrivateKey) keyPair.getPrivate();
        this.publicKey = (RSAPublicKey) keyPair.getPublic();
    }

    /**
     * 从文件中输入流中加载公钥
     *
     * @param in 公钥输入流
     * @throws Exception 加载公钥时产生的异常
     */
    public void loadPublicKey(InputStream in) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String readLine = null;
            StringBuilder sb = new StringBuilder();
            while ((readLine = br.readLine()) != null) {
                if (readLine.charAt(0) == '-') {
                    continue;
                } else {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
            loadPublicKey(sb.toString());
        } catch (IOException e) {
            throw new Exception("公钥数据流读取错误");
        } catch (NullPointerException e) {
            throw new Exception("公钥输入流为空");
        }
    }

    public static String getKeyString(Key key) throws Exception {
        byte[] keyBytes = key.getEncoded();
        BASE64Encoder encoder = new BASE64Encoder();
        String s = encoder.encode(keyBytes);
        return s;
    }

    /**
     * 从字符串中加载公钥
     *
     * @param publicKeyStr 公钥数据字符串
     * @throws Exception 加载公钥时产生的异常
     */
    public void loadPublicKey(String publicKeyStr) throws Exception {
        try {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] buffer = base64Decoder.decodeBuffer(publicKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            this.publicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("公钥非法");
        } catch (NullPointerException e) {
            throw new Exception("公钥数据为空");
        }
    }

    /**
     * 用公钥验证签名的正确性  *  * @param message  * @param signStr  * @return  * @throws Exception
     */
    public boolean verifySign(String message, String signStr, PublicKey key) throws Exception {
        if (message == null || signStr == null || key == null) {
            return false;
        }
        Signature signetcheck = Signature.getInstance("MD5withRSA");
        signetcheck.initVerify(key);
        signetcheck.update(message.getBytes("UTF-8"));
        return signetcheck.verify(toBytes(signStr));
    }

    public byte[] sign(String message, PrivateKey key) throws Exception {
        Signature signetcheck = Signature.getInstance("MD5withRSA");
        signetcheck.initSign(key);
        signetcheck.update(message.getBytes("UTF-8"));
        return signetcheck.sign();
    }

    public static final byte[] toBytes(String s) {
        byte[] bytes;
        bytes = new byte[s.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }

    /**
     * 从文件中加载私钥
     *
     * @param in 私钥文件名
     * @return 是否成功
     * @throws Exception
     */
    public void loadPrivateKey(InputStream in) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String readLine = null;
            StringBuilder sb = new StringBuilder();
            while ((readLine = br.readLine()) != null) {
                if (readLine.charAt(0) == '-') {
                    continue;
                } else {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
            loadPrivateKey(sb.toString());
        } catch (IOException e) {
            throw new Exception("私钥数据读取错误");
        } catch (NullPointerException e) {
            throw new Exception("私钥输入流为空");
        }
    }

    public void loadPrivateKey(String privateKeyStr) throws Exception {
        try {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] buffer = base64Decoder.decodeBuffer(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            this.privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("私钥非法");
        } catch (NullPointerException e) {
            throw new Exception("私钥数据为空");
        }
    }

    /**
     * 加密过程
     *
     * @param publicKey     公钥
     * @param plainTextData 明文数据
     * @return
     * @throws Exception 加密过程中的异常信息
     */
    public byte[] encrypt(RSAPublicKey publicKey, byte[] plainTextData) throws Exception {
        if (publicKey == null) {
            throw new Exception("加密公钥为空, 请设置");
        }
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] output = cipher.doFinal(plainTextData);
            return output;
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此加密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e) {
            throw new Exception("加密公钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("明文长度非法");
        } catch (BadPaddingException e) {
            throw new Exception("明文数据已损坏");
        }
    }

    /**
     * 解密过程
     *
     * @param privateKey 私钥
     * @param cipherData 密文数据
     * @return 明文
     * @throws Exception 解密过程中的异常信息
     */
    public byte[] decrypt(RSAPrivateKey privateKey, byte[] cipherData) throws Exception {
        if (privateKey == null) {
            throw new Exception("解密私钥为空, 请设置");
        }
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] output = cipher.doFinal(cipherData);
            return output;
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此解密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e) {
            throw new Exception("解密私钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("密文长度非法");
        } catch (BadPaddingException e) {
            throw new Exception("密文数据已损坏");
        }
    }


//    /**	
//     * 字节数据转十六进制字符串	
//     *	
//     * @param data 输入数据	
//     * @return 十六进制内容	
//     */	
//    public static String byteArrayToString(byte[] data) {	
//        StringBuilder stringBuilder = new StringBuilder();	
//        for (int i = 0; i < data.length; i++) {	
//            //取出字节的高四位 作为索引得到相应的十六进制标识符 注意无符号右移	
//            stringBuilder.append(HEX_CHAR[(data[i] & 0xf0) >>> 4]);	
//            //取出字节的低四位 作为索引得到相应的十六进制标识符	
//            stringBuilder.append(HEX_CHAR[(data[i] & 0x0f)]);	
//            if (i < data.length - 1) {	
//                //stringBuilder.append('');	
//            }	
//        }	
//        return stringBuilder.toString();	
//    }	

//    public static String toHexString(byte[] b) {	
//        StringBuilder sb = new StringBuilder(b.length * 2);	
//        for (int i = 0; i < b.length; i++) {	
//            sb.append(HEX_CHAR[(b[i] & 0xf0) >>> 4]);	
//            sb.append(HEX_CHAR[b[i] & 0x0f]);	
//        }	
//        return sb.toString();	
//    }	

    public static byte[] hex2byte(byte[] b) {

        if ((b.length % 2) != 0)

            throw new IllegalArgumentException("长度不是偶数");

        byte[] b2 = new byte[b.length / 2];

        for (int n = 0; n < b.length; n += 2) {

            String item = new String(b, n, 2);

            b2[n / 2] = (byte) Integer.parseInt(item, 16);

        }

        return b2;
    }

    public static String decrypt(String encryptStr) {
        RSAUtils rsaEncrypt = new RSAUtils();
        String decryptStr = "";
        //加载私钥  	
        try {
            rsaEncrypt.loadPrivateKey(PRIVATE_KEY_PASSWORD);
            //  logger.info("加载私钥成功");	
        } catch (Exception e) {
            e.printStackTrace();
//            Logger.e(e.getMessage());	
//            Logger.e("加载私钥失败");	
        }

        try {
            //解密	
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] plainText = rsaEncrypt.decrypt(rsaEncrypt.getPrivateKey(), decoder.decodeBuffer(encryptStr));
//            logger.debug("明文长度:"+ plainText.length);	
//            logger.debug(RSAUtils.byteArrayToString(plainText));	

            decryptStr = new String(plainText);
        } catch (Exception e) {
            e.printStackTrace();
//            Logger.e(e.getMessage());	
        }
        return decryptStr;
    }

    public static String decryptKey(String encryptStr, String key) {
        RSAUtils rsaEncrypt = new RSAUtils();
        String decryptStr = "";
        //加载私钥
        try {
            rsaEncrypt.loadPrivateKey(key);
            //  logger.info("加载私钥成功");
        } catch (Exception e) {
            e.printStackTrace();
//            Logger.e(e.getMessage());
//            Logger.e("加载私钥失败");
        }

        try {
            //解密
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] plainText = rsaEncrypt.decrypt(rsaEncrypt.getPrivateKey(), decoder.decodeBuffer(encryptStr));
//            logger.debug("明文长度:"+ plainText.length);
//            logger.debug(RSAUtils.byteArrayToString(plainText));

            decryptStr = new String(plainText);
        } catch (Exception e) {
            e.printStackTrace();
//            Logger.e(e.getMessage());
        }
        return decryptStr;
    }

    public static String encrypt(String decryptStr) {
        RSAUtils rsaEncrypt = new RSAUtils();
        String encryptStr = "";

        //加载公钥  	
        try {
            rsaEncrypt.loadPublicKey(PUBLIC_KEY_PASSWORD);
            //  logger.info("加载公钥成功");	
        } catch (Exception e) {
//            Logger.e(e.getMessage());	
//            Logger.e("加载公钥失败");	
        }

        try {
            //加密  	
            byte[] cipher = rsaEncrypt.encrypt(rsaEncrypt.getPublicKey(), decryptStr.getBytes());
//            Logger.d("密文长度:" + cipher.length);	
//            Logger.d(RSAUtils.byteArrayToString(cipher));	
//            Logger.d(RSAUtils.toHexString(cipher));	

            BASE64Encoder encoder = new BASE64Encoder();
            encryptStr = encoder.encodeBuffer(cipher);
        } catch (Exception e) {
//            Logger.e(e.getMessage());	
        }
        return encryptStr;
    }


    public static void main(String args[]) throws Exception {
//        String aa = "梁测试";	
//        String bb = RSAUtils.encrypt(aa);	
//        String cc = RSAUtils.decrypt(bb);	
//        System.out.println(aa);	
//        System.out.print(bb);	
//        System.out.print(cc);	
        String dd = "RM647eL7dHB4a4vb16OkFV3RKQF8eJvWXzuNC9YKEWZkVrrwYnoEeWPH6B8vy+if2c+SZPeDKezapSdMUp8tjpEctSEjQT/n7Mxk7WHhde+BZBgRNTnOcJHrTZ+Z8KKiXv0R+gF51nMuMjm0h5phF9c0RzZQAmaEE9NT6fXry54=";
        String ee = RSAUtils.decrypt(dd);
        System.out.println(ee);
    }
}  	
