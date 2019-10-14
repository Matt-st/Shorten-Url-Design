package com.tinyurl.service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import com.tinyurl.model.TinyUrl;

public interface TinyUrlService {
	public TinyUrl createTinyUrl(String longUrl) throws Exception;

	public Optional<TinyUrl> retrieveTinyUrl(String shortUrl);
}
