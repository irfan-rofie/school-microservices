package com.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.dto.RecordAttendanceDto;
import com.attendance.model.Attendance;
import com.attendance.service.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
	
    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/record")
    public ResponseEntity<Attendance> recordAttendance(
            @RequestBody RecordAttendanceDto dto) {
        Attendance attendance = attendanceService.recordAttendance(dto);
        return ResponseEntity.ok(attendance);
    }
    
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Attendance>> getAttendanceByStudent(@PathVariable Long studentId) {
        List<Attendance> attendances = attendanceService.getAttendanceByStudent(studentId);
        return ResponseEntity.ok(attendances);
    }
    
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Attendance>> getAttendanceByCourse(@PathVariable Long courseId) {
        List<Attendance> attendances = attendanceService.getAttendanceByCourse(courseId);
        return ResponseEntity.ok(attendances);
    }
}
