package com.teacher.controller;

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

import com.teacher.model.Teacher;
import com.teacher.service.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
	
    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> editTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
    	Optional<Teacher> optTeacher = teacherService.getTeacherById(id);
    	if (!optTeacher.isPresent()) {
    		return ResponseEntity.notFound().build();
    	}
    	teacher.setId(optTeacher.get().getId());
        return ResponseEntity.ok(teacherService.saveTeacher(teacher));
    }
    
    @GetMapping
    public List<Teacher> getTeacher() {
        return teacherService.getTeacher();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Long id) {
    	Optional<Teacher> teacher = teacherService.getTeacherById(id);
        return teacher.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}
