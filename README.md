# Application Overview
This application will consist of several microservices, each responsible for a different aspect of the school's operations. We will focus on four core features: Student Management, Teacher Management, Course Management, and Attendance Tracking. The application will be designed with Clean Architecture principles to ensure modularity, testability, and scalability.

1. Student Management Service
- Features:
  - Add, update, and delete student records.
  - View student details.
    
- Endpoints:
  - POST /students - Add a new student.
  - PUT /students/{id} - Update a student's details.
  - DELETE /students/{id} - Delete a student.
  - GET /students/{id} - View a student's details.

2. Teacher Management Service
- Features:
  - Add, update, and delete teacher records.
  - View teacher details.

- Endpoints:
  - POST /teachers - Add a new teacher.
  - PUT /teachers/{id} - Update a teacher's details.
  - DELETE /teachers/{id} - Delete a teacher.
  - GET /teachers/{id} - View a teacher's details.

3. Course Management Service
- Features:
  - Add, update, and delete courses.
  - Assign teachers to courses.
  - Enroll students in courses.
- Endpoints:
  - POST /courses - Add a new course.
  - PUT /courses/{id} - Update a course's details.
  - DELETE /courses/{id} - Delete a course.
  - POST /courses/{id}/assign-teacher - Assign a teacher to a course.
  - POST /courses/{id}/enroll-student - Enroll a student in a course.

4. Attendance Tracking Service
- Features:
  - Record attendance for students.
  - View attendance records.
- Endpoints:
  - POST /attendance - Record attendance for a student.
  - GET /attendance/{studentId} - View a student's attendance record.
