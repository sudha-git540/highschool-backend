package com.highschool.backend.controller;

import com.highschool.backend.entity.Question;
import com.highschool.backend.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/lesson/{lessonId}")
    public ResponseEntity<Question> createQuestion(
            @PathVariable Long lessonId,
            @RequestBody Question question) {

        Question createdQuestion =
                questionService.createQuestion(
                        lessonId,
                        question
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdQuestion);
    }

    @GetMapping("/lesson/{lessonId}")
    public ResponseEntity<List<Question>> getQuestionsByLesson(
            @PathVariable Long lessonId) {

        return ResponseEntity.ok(
                questionService.getQuestionsByLesson(lessonId)
        );
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<Question> getQuestionById(
            @PathVariable Long questionId) {

        return ResponseEntity.ok(
                questionService.getQuestionById(questionId)
        );
    }
}