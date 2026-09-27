package com.highschool.backend.controller;

import com.highschool.backend.entity.MCQAttempt;
import com.highschool.backend.service.MCQAttemptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mcq-attempts")
public class MCQAttemptController {

    private final MCQAttemptService mcqAttemptService;

    public MCQAttemptController(
            MCQAttemptService mcqAttemptService
    ) {
        this.mcqAttemptService = mcqAttemptService;
    }

    @PostMapping
    public ResponseEntity<MCQAttempt> saveAttempt(
            @RequestParam String studentId,
            @RequestParam Long lessonId,
            @RequestParam Integer totalQuestions,
            @RequestParam Integer correctAnswers
    ) {

        MCQAttempt attempt = mcqAttemptService.saveAttempt(
                studentId,
                lessonId,
                totalQuestions,
                correctAnswers
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(attempt);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<MCQAttempt>> getStudentAttempts(
            @PathVariable String studentId
    ) {
        return ResponseEntity.ok(
                mcqAttemptService.getStudentAttempts(studentId)
        );
    }

    @GetMapping("/student/{studentId}/lesson/{lessonId}")
    public ResponseEntity<List<MCQAttempt>> getLessonAttempts(
            @PathVariable String studentId,
            @PathVariable Long lessonId
    ) {
        return ResponseEntity.ok(
                mcqAttemptService.getLessonAttempts(
                        studentId,
                        lessonId
                )
        );
    }
}