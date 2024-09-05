package com.course.controller;

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

import com.course.dto.CourseDto;
import com.course.model.Course;
import com.course.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course addCourse(@RequestBody CourseDto dto) {
        return courseService.saveCourse(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> editCourse(@PathVariable Long id, @RequestBody CourseDto dto) {
    	Course updateCourse = courseService.updateCourse(id, dto);
    	if (updateCourse == null) {
    		return ResponseEntity.notFound().build();	
    	}
        return ResponseEntity.ok(updateCourse);
    }
    
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> course = courseService.getCourseById(id);
        return course.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{courseId}/assign-teacher/{teacherId}")
    public ResponseEntity<Course> assignTeacherToCourse(@PathVariable Long courseId, @PathVariable Long teacherId) {
        Course updatedCourse = courseService.assignTeacherToCourse(courseId, teacherId);
        if (updatedCourse == null) {
        	return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
