//package com.cdi.springboot_with_mongoDb;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
//
//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.client.gridfs.GridFSBucket;
//import com.mongodb.client.gridfs.GridFSBuckets;
//
//@Configuration
//public class UserConfiguration extends  AbstractMongoConfiguration{
//
//	@Override
//	@Bean
//	public MongoClient mongoClient() {
//		return null;
//	}
//
//	@Override
//	protected String getDatabaseName() {
//		
//		return null;
//	}
//	@Bean 
//	public GridFSBucket getGridFSBuckets() {
//		MongoDatabase db = mongoDbFactory().getDb();
//		return GridFSBuckets.create(db);
//		}
//	
//
//}
