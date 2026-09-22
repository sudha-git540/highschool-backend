package com.highschool.backend.controller;

import com.highschool.backend.entity.Student;
import com.highschool.backend.service.StudentService;
import com.highschool.backend.dto.StudentRegistrationRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
