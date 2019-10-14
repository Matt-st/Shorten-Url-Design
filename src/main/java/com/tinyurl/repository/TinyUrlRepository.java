package com.tinyurl.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tinyurl.model.TinyUrl;

public interface TinyUrlRepository extends CrudRepository<TinyUrl, String>{

	Optional<TinyUrl> findOneBytinyUrl(String url);
}
