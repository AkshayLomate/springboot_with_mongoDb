package com.cdi.springboot_with_mongoDb.repository;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.cdi.springboot_with_mongoDb.model.User;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;

public interface UserREpository extends MongoRepository<User, String> {
	
	
	

}
