package com.highschool.backend.controller;

import com.highschool.backend.dto.StudentLoginRequest;
import com.highschool.backend.entity.Student;
import com.highschool.backend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Student> login(
            @Valid @RequestBody StudentLoginRequest request) {

        Student student = authService.loginStudent(request);

        return ResponseEntity.ok(student);
    }
}
