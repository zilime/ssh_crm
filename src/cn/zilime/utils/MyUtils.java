package cn.zilime.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;



public class MyUtils {
	public static String transferDate(Date date,String format){
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	public static String md5(String p){
		byte[] secretBytes=null;
		
		try {
			secretBytes=MessageDigest.getInstance("md5").digest(p.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("√ª’“µΩmd5À„∑®");
		}
		String md5code=new BigInteger(1,secretBytes).toString(16);
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}
	
}
