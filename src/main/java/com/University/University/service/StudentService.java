package com.University.University.service;

import java.util.Map;

import com.University.University.model.Student;

public interface StudentService {

	void saveStudent(Student student);
    Student getOneStudent(Integer id);
    void updateStudent(Student student);
    Map<Integer, Student> getAllStudents();
    void deleteStudent(Integer id);
    void saveAllStudents(Map<Integer, Student> map);
    
}
