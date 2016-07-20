package com.rent.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

public class passwordUtil {
	public static String  message(String password){
		try {
			MessageDigest md=MessageDigest.getInstance("md5");
			byte md5[]=  md.digest(password.getBytes());
			BASE64Encoder encoder=new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
