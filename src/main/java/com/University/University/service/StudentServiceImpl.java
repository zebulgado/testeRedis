package com.University.University.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.University.University.model.Student;
import com.University.University.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	} 
	
    @Override 
    public void saveStudent(Student student) {
        //creates one record in Redis DB if record with that Id is not present
    	studentRepository.save(student);
    }

    @Override
    public void saveAllStudents(Map<Integer, Student> map) {
    	studentRepository.saveAll(map);
    }

    @Override
    public Student getOneStudent(Integer id) {
       return studentRepository.getOne(id);
    }

    @Override
    public void updateStudent(Student student) {
    	studentRepository.update(student);
    }

    @Override
    public Map<Integer, Student> getAllStudents() {
    	return studentRepository.getAll();
    }

    @Override
    public void deleteStudent(Integer id) {
    	studentRepository.delete(id);
    }
}
