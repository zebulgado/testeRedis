package com.University.University.repository;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.University.University.model.Student;

@Repository
public interface StudentRepository {
		
	void save(Student student);
    Student getOne(Integer id);
    void update(Student student);
    Map<Integer, Student> getAll();
    void delete(Integer id);
    void saveAll(Map<Integer, Student> map);
    
}
