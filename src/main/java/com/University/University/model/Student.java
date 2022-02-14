package com.University.University.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash
public class Student implements Serializable{
		
	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String cpf;
	private String name;
	
}
