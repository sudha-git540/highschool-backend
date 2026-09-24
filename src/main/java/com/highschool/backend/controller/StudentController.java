package com.highschool.backend.controller;
import com.highschool.backend.dto.StudentLoginRequest;
import com.highschool.backend.entity.Student;
import com.highschool.backend.service.StudentService;
import com.highschool.backend.dto.StudentRegistrationRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(
            @Valid @RequestBody StudentRegistrationRequest request) {
        Student student = studentService.registerStudent(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(student);
    }
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentByStudentId(
            @PathVariable String studentId){

        Student student = studentService.getStudentByStudentId(
                studentId
        );

        return ResponseEntity.ok(student);
    }
    @PostMapping("/login")
    public ResponseEntity<Student> loginStudent(
            @Valid @RequestBody StudentLoginRequest request) {

        Student student = studentService.loginStudent(
                request.getStudentId(),
                request.getMobileNumber()
        );

        return ResponseEntity.ok(student);
    }
}
