package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable Long id, @RequestBody Student student) throws Exception {
        Optional<Student> optStudet = studentService.getStudentById(id);
        if (!optStudet.isPresent()) {
    		return ResponseEntity.notFound().build();
    	}
    	student.setId(optStudet.get().getId());
        return ResponseEntity.ok(studentService.saveStudent(student));
    }
    
    @GetMapping
    public List<Student> getStudent() {
        return studentService.getStudent();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) throws Exception {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
