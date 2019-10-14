package com.tinyurl.service;

import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tinyurl.utils.TinyUrlConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TinyUrlTest {

    @Autowired
    TinyUrlConverter converter;

    @DisplayName("Test Tiny Url conversion algorithm")
    @Test
    void testGet() throws NoSuchAlgorithmException {
        assertEquals("BRRbYby",converter.convertToBase62Url("www.google.com"));
    }
	
}
