package com.cn.wy.utils;

import java.security.MessageDigest;

/**
 * 密码加密�?
 * @author gcg
 *
 */
public class MD5Util {
	
	/**
	 * 加密算法
	 * @param s 密码
	 * @return
	 */
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法�? MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘�?
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * �?验密�? 
	 * @param putInPwd 输入的密�?
	 * @param oldPwd 原来的密�?
	 * @return
	 */
	public final static boolean checkPassword(String putInPwd, String oldPwd) {
		return MD5(putInPwd).equals(oldPwd);
	} 
	
}
