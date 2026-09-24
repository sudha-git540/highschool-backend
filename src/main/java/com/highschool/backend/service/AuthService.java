package com.highschool.backend.service;
import com.highschool.backend.dto.StudentLoginRequest;
import com.highschool.backend.entity.Student;
import com.highschool.backend.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final StudentRepository studentRepository;

    public AuthService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student loginStudent(StudentLoginRequest request) {

        return studentRepository
                .findByStudentIdAndMobileNumber(
                        request.getStudentId(),
                        request.getMobileNumber()
                )
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Invalid Student ID or mobile number"
                        )
                );
    }
}
