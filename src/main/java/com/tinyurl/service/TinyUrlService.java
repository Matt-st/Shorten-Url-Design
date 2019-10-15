package com.tinyurl.service;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;

import com.tinyurl.model.TinyUrl;

public interface TinyUrlService {
	public TinyUrl createTinyUrl(String longUrl) throws Exception;

	@Cacheable(value = "retrieveTinyUrlCache", key = "#shortUrl")
	public Optional<TinyUrl> retrieveTinyUrl(String shortUrl);
}
