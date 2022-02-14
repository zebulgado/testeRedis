package com.University.University.repository;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.University.University.model.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository{

	private final String hashReference = "Student";	

    @Resource(name="redisTemplate")          // 'redisTemplate' is defined as a Bean in AppConfig.java
    private HashOperations<String, Integer, Student> hashOperations;

	//private RedisTemplate<String, Student> redisTemplate; 
	
    //@Override 
    public void save(Student student) {
        //creates one record in Redis DB if record with that Id is not present
        hashOperations.putIfAbsent(hashReference, student.getId(), student);
    }

   // @Override
    public void saveAll(Map<Integer, Student> map) {
        hashOperations.putAll(hashReference, map);
    }

   // @Override
    public Student getOne(Integer id) {
       return hashOperations.get(hashReference, id);
    }

  //  @Override
    public void update(Student student) {
       hashOperations.put(hashReference, student.getId(), student);
    }

  //  @Override
    public Map<Integer, Student> getAll() {
       return hashOperations.entries(hashReference);
    }

   // @Override
    public void delete(Integer id) {
       hashOperations.delete(hashReference, id);
    }
}
