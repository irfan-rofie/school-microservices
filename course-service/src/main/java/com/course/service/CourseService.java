package com.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dto.CourseDto;
import com.course.model.Course;
import com.course.model.Teacher;
import com.course.repository.CourseRepository;
import com.course.repository.TeacherRepository;

@Service
public class CourseService {

	@Autowired
    private CourseRepository courseRepository;
	
	@Autowired
    private TeacherRepository teacherRepository;

	public Course saveCourse(CourseDto dto) {
		Course course = new Course();
		course.setName(dto.getName());
		course.setDescription(dto.getDescription());
		course.setTeacher(teacherRepository.findById(dto.getTeacherId()).orElse(null));
        return courseRepository.save(course);
    }

	public Course updateCourse(Long id, CourseDto dto) {
		Course course = courseRepository.findById(id).orElse(null);
		if (course != null) {
			course.setName(dto.getName());
			course.setDescription(dto.getDescription());
			course.setTeacher(teacherRepository.findById(dto.getTeacherId()).orElse(null));
	        return courseRepository.save(course);
		}
		return null;
    }
	
	public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    
	public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

	public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
	
	public Course assignTeacherToCourse(Long courseId, Long teacherId) {
		Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course != null && teacher != null) {
            course.setTeacher(teacher);
            return courseRepository.save(course);        	
        }
        return null;
    }
}
