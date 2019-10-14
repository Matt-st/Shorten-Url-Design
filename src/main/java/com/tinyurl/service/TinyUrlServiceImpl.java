package com.tinyurl.service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tinyurl.model.TinyUrl;
import com.tinyurl.repository.TinyUrlRepository;
import com.tinyurl.utils.TinyUrlConverter;

@Component
public class TinyUrlServiceImpl implements TinyUrlService {
	@Autowired
	TinyUrlConverter converter;
	
	@Autowired
	TinyUrlRepository repo;

	public TinyUrl createTinyUrl(String longUrl) throws NoSuchAlgorithmException {
		TinyUrl url = new TinyUrl(longUrl);
		url.setTinyUrl(converter.convertToBase62Url(longUrl));
		repo.save(url);
		return url;
	}

	public Optional<TinyUrl> retrieveTinyUrl(String shortUrl) {
		return repo.findOneBytinyUrl(shortUrl);
	}

}
