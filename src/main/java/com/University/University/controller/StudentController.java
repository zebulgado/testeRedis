package com.University.University.controller;

import java.net.URI;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.University.University.model.Student;
import com.University.University.service.StudentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

	@RestController
	@RequestMapping(path = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
	public class StudentController {
		
		private StudentService studentService;

		public StudentController(StudentService studentService) {
			super();
			this.studentService = studentService;
		}

		@ApiOperation(value = "Get all Students")
		@ApiResponses({ @ApiResponse(code = 200, message = "OK") })
		@GetMapping
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<Map<Integer, Student>> getStudentList() {
			Map<Integer, Student> students = studentService.getAllStudents();
			return ResponseEntity.ok().body(students);
		}

		@ApiOperation(value = "Get student")
		@ApiResponses({ @ApiResponse(code = 200, message = "OK"), 
						@ApiResponse(code = 400, message = "Bad Request"),
						@ApiResponse(code = 404, message = "Not Found") })
		@GetMapping(value = "/{id}")
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<Student> getStudent(@PathVariable(value = "id") Integer id) {
			Student student = studentService.getOneStudent(id);
			if (student == null) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok().body(student);
			}
		}

		@ApiOperation(value = "Create student")
		@ApiResponses({ @ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 400, message = "Bad Request") })
		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<Student> createStudent(@RequestBody Student student) {
			studentService.saveStudent(student);
			if (student == null) {
				return ResponseEntity.badRequest().build();
			} else {
				return ResponseEntity.created(URI.create("/" + student.getId().toString())).build();
			}
		}

		@ApiOperation(value = "Update student")
		@ApiResponses({ @ApiResponse(code = 200, message = "OK"), 
						@ApiResponse(code = 400, message = "Bad Request"),
						@ApiResponse(code = 404, message = "Not Found") })
		@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
			studentService.updateStudent(student);
			if (student == null) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok().body(student);
			}
		}

		@ApiOperation(value = "Delete student")
		@ApiResponses({ @ApiResponse(code = 204, message = "No Content"),
						@ApiResponse(code = 400, message = "Bad Request") })
		@DeleteMapping(value = "/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public ResponseEntity<Void> deleteStudent(@PathVariable(value = "id") Integer id) {
			studentService.deleteStudent(id);
			return ResponseEntity.noContent().build();
		}
}
