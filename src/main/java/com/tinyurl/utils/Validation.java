package com.tinyurl.utils;

import java.net.URL;

public class Validation {
	 /* Returns true if url is valid */
    public static boolean isValid(String url) 
    { 
        try { 
            new URL(url).toURI(); 
            System.out.println("This is valid");
            return true; 
        }catch (Exception e) { 
        	System.out.println("This is invalid");
            return false; 
        } 
    } 
}
