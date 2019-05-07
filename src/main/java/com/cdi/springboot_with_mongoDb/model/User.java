package com.cdi.springboot_with_mongoDb.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
	

	@Id
	private String id;
	private String name;
	private String email;
	private int age;

}
