package com.test123.springbootdemo.repository;

import com.test123.springbootdemo.document.Dict;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author hotleave
 */
public interface DictMongoRepository extends MongoRepository<Dict, String> {
}
