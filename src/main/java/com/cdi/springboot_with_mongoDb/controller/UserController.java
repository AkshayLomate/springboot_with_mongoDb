package com.cdi.springboot_with_mongoDb.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.gridfs.model.GridFSFile;

@RestController
@RequestMapping(value = "user")
public class UserController {
	@Autowired
	GridFsOperations gridFsOperations;

	@Autowired
	private GridFsTemplate gridFsTemplate;

	/*
	 * @RequestMapping(value = "/retrive",method = RequestMethod.GET, produces =
	 * MediaType.APPLICATION_JSON_VALUE) public GridFSDBFile retrieveFile()
	 * throwsIOException { // read file from MongoDB GridFSDBFile imageFile =
	 * gridFsOperations.findOne(new Query(Criteria.where("_id").is(imageFileId)));
	 * return imageFile; }
	 */

	@RequestMapping(value = "/retrive", method = RequestMethod.GET,produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<GridFsResource> retriveFile(@RequestParam(value = "id") String id) {
		try {
		GridFSFile file = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(id)));
		
		System.out.println("got the hold of file ");
		
		GridFsResource resource =new GridFsResource(file);
		System.out.println("converting it to inputstream");
         
			System.out.println("Returning the response");
			  return ResponseEntity.ok()
			            .contentLength(file.getLength())
			            .body(gridFsOperations.getResource(file));
			//return ResponseEntity.ok().contentLength(resource.contentLength())
					//.contentType(MediaType.parseMediaType(resource.getContentType())).body(gridFsOperations.getResource(file));
        // return resource;
		
		} catch (Exception e) {
			System.out.println("Some Error: " + e.getMessage());
		}

		return null;
	}
}
