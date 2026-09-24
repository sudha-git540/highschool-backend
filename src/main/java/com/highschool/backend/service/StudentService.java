package com.highschool.backend.service;
import com.highschool.backend.entity.Student;
import com.highschool.backend.repository.StudentRepository;
import com.highschool.backend.dto.StudentRegistrationRequest;
import org.springframework.stereotype.Service;
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student registerStudent(StudentRegistrationRequest request) {
        // Check whether mobile number is already registered
        if (studentRepository.findByMobileNumber(request.getMobileNumber()).isPresent()) {
            throw new IllegalArgumentException(
                    "Mobile number is already registered"
            );
        }
        // Generate Student ID
        String studentId = generateStudentId(request.getClassNumber());
        // Create Student entity
        Student student = new Student(
                studentId,
                request.getName(),
                request.getMobileNumber(),
                request.getClassNumber()
        );
        // Save student to MySQL
        return studentRepository.save(student);
    }
    private String generateStudentId(Integer classNumber) {
        long nextNumber = studentRepository.count() + 1;
        return String.format(
                "APH-%d-%06d",
                classNumber,
                nextNumber
        );
    }
    public Student getStudentByStudentId(
            String studentId) {

        return studentRepository
                .findByStudentId(
                        studentId
                )
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Student details do not match"
                        )
                );
    }
}
