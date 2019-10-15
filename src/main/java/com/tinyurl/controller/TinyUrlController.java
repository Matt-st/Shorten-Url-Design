package com.tinyurl.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tinyurl.model.RequestUrl;
import com.tinyurl.model.ResponseUrl;
import com.tinyurl.model.TinyUrl;
import com.tinyurl.service.TinyUrlService;
import com.tinyurl.utils.TinyUrlConverter;
import com.tinyurl.utils.Validation;

@RestController
public class TinyUrlController {
	
	@Autowired
	TinyUrlService service;

	@RequestMapping(value = "/url", method = RequestMethod.POST)
	public ResponseEntity<ResponseUrl> shortenUrl(@RequestBody RequestUrl requestUrl) throws Exception {
		ResponseUrl s = new ResponseUrl();
		System.out.println("Abbout to check");
		if(!Validation.isValid(requestUrl.getUrl())){
			return new ResponseEntity<ResponseUrl>(s, HttpStatus.BAD_REQUEST);
		}
		TinyUrl tinyUrl = service.createTinyUrl(requestUrl.getUrl());
		s.setUrl(tinyUrl.getTinyUrl());
		return new ResponseEntity<ResponseUrl>(s, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/url", method = RequestMethod.GET)
	public ResponseEntity<ResponseUrl> getUrl(@RequestBody RequestUrl requestUrl) throws Exception {
		ResponseUrl s = new ResponseUrl();
		Optional<TinyUrl> tinyUrl = service.retrieveTinyUrl(requestUrl.getUrl());
		if(tinyUrl.isPresent()){
			s.setUrl(tinyUrl.get().getLongUrl());
			return new ResponseEntity<ResponseUrl>(s, HttpStatus.OK);
		}
		return new ResponseEntity<ResponseUrl>(s, HttpStatus.NOT_FOUND);
	}
	
}
