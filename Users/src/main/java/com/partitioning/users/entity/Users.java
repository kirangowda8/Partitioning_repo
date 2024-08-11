package com.partitioning.users.entity;

import java.time.LocalDate;

import com.partitioning.users.entity.compositekey.UsersCompKey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

	@EmbeddedId
	 UsersCompKey usersCompKey;
	
	private String name;
	
	private LocalDate creationDate;
	
	private String state;
	
	private LocalDate dOb;
	
	private byte Age;
	
	
}
