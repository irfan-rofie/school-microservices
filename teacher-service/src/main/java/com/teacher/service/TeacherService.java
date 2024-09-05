package com.teacher.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teacher.model.Teacher;
import com.teacher.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
    private TeacherRepository teacherRepository;

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getTeacher() {
        return teacherRepository.findAll();
    }
    
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public void deleteTeacher(Long id) {
    	teacherRepository.deleteById(id);
    }
}
