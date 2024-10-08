package com.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendance.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
