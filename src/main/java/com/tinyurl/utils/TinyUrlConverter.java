package com.tinyurl.utils;

import io.seruco.encoding.base62.Base62;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

@SuppressWarnings("restriction")
@Service
public class TinyUrlConverter {
	
	public String convertToBase62Url(String urlToConvert) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("md5");
		md.update(urlToConvert.getBytes());
		byte[] digest = md.digest();
		String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		Base62 base62 = Base62.createInstance();
		final byte[] encoded = base62.encode(myHash.getBytes());

		
		return new String(encoded).substring(0, 7);
	
	}

}
