package com.fairytale.webserver.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Copyright (c) 2014 Guangzhou YuYan Commercial Co.,Ltd.
 * @author Liudishi
 * 2014��8��24��
 */
public class SecurityUtils {

	private static final Logger logger = LoggerFactory.getLogger(SecurityUtils.class);
	
	private static final String AES = "AES";
	private static final String DEFAULT_AES_CRYPT_KEY = "YUYAN";
	
	/**
	 * ��������ַ����MD5����
	 * 
	 * @param str ��Ҫ���ܵ��ַ�
	 * 
	 * @return MD5���ܺ���ַ�
	 */
	public static String getMD5(String str) {
		if (StringUtils.isEmpty(str)) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] digest = messageDigest.digest(str.getBytes());
			return new String(Hex.encodeHex(digest));
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	
	public static String encryptAES(String content) {
		return encryptAES(content, DEFAULT_AES_CRYPT_KEY);
	}

	/**
	 * AES����
	 * 
	 * @param content ��Ҫ���ܵ��ַ�
	 * 
	 * @param key ��Կ
	 * 
	 * @return
	 */
	public static String encryptAES(String content, String key) {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128, new SecureRandom(key.getBytes()));
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// ����������
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);// ��ʼ��
			byte[] result = cipher.doFinal(byteContent);
			return parseByte2HexStr(result); // ����
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	/**
	 * ʹ��Ĭ����Կ���� AES����
	 * 
	 * @param content
	 * @return
	 */
	public static String decryptAES(String content) {
		return decryptAES(content, DEFAULT_AES_CRYPT_KEY);
	}

	/**
	 * AES����
	 * 
	 * @param content
	 *            ���������
	 * @param key
	 *            ������Կ
	 * @return
	 */
	public static String decryptAES(String content, String key) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(key.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// ����������
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);// ��ʼ��
			byte[] result = cipher.doFinal(parseHexStr2Byte(content));
			return new String(result); // ����
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	/**
	 * ��16����ת��Ϊ������
	 * 
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
					16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}
	
	/**
	 * ��������ת����16����
	 * 
	 * @param buf
	 * @return
	 */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			stringBuffer.append(hex.toUpperCase());
		}
		return stringBuffer.toString();
	}
	
	
	
	
	
	
	/** 
     * ���� 
     *  
     * @param encryptStr 
     * @return 
     */  
    public static byte[] encrypt(byte[] src, String key) throws Exception {  
        Cipher cipher = Cipher.getInstance(AES);  
        SecretKeySpec securekey = new SecretKeySpec(key.getBytes(), AES);  
        cipher.init(Cipher.ENCRYPT_MODE, securekey);//������Կ�ͼ�����ʽ  
        return cipher.doFinal(src);  
    }  
  
    /** 
     * ���� 
     *  
     * @param decryptStr 
     * @return 
     * @throws Exception 
     */  
    public static byte[] decrypt(byte[] src, String key)  throws Exception  {  
        Cipher cipher = Cipher.getInstance(AES);  
        SecretKeySpec securekey = new SecretKeySpec(key.getBytes(), AES);//���ü���Key  
        cipher.init(Cipher.DECRYPT_MODE, securekey);//������Կ�ͽ�����ʽ  
        return cipher.doFinal(src);  
    }  
      
    /** 
     * ������תʮ������ַ� 
     *  
     * @param b 
     * @return 
     */  
    public static String byte2hex(byte[] b) {  
        String hs = "";  
        String stmp = "";  
        for (int n = 0; n < b.length; n++) {  
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));  
            if (stmp.length() == 1)  
                hs = hs + "0" + stmp;  
            else  
                hs = hs + stmp;  
        }  
        return hs.toUpperCase();  
    }  
  
    public static byte[] hex2byte(byte[] b) {  
        if ((b.length % 2) != 0)  
            throw new IllegalArgumentException("���Ȳ���ż��");  
        byte[] b2 = new byte[b.length / 2];  
        for (int n = 0; n < b.length; n += 2) {  
            String item = new String(b, n, 2);  
            b2[n / 2] = (byte) Integer.parseInt(item, 16);  
        }  
        return b2;  
    }  
      
    /** 
     * ���� 
     *  
     * @param data 
     * @return 
     * @throws Exception 
     */  
    public final static String decrypt(String data) {  
        try {  
            return new String(decrypt(hex2byte(data.getBytes()),  
            		DEFAULT_AES_CRYPT_KEY));  
        } catch (Exception e) {  
        }  
        return null;  
    }  
  
    /** 
     * ���� 
     *  
     * @param data 
     * @return 
     * @throws Exception 
     */  
    public final static String encrypt(String data) {  
        try {  
            return byte2hex(encrypt(data.getBytes(), DEFAULT_AES_CRYPT_KEY));  
        } catch (Exception e) {  
        }
        return null;  
    }  

}
