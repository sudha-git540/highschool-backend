package com.highschool.backend.controller;

import com.highschool.backend.entity.MockTestQuestion;
import com.highschool.backend.service.MockTestQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mock-test-questions")
public class MockTestQuestionController {

    private final MockTestQuestionService mockTestQuestionService;

    public MockTestQuestionController(
            MockTestQuestionService mockTestQuestionService
    ) {
        this.mockTestQuestionService = mockTestQuestionService;
    }

    @PostMapping
    public ResponseEntity<MockTestQuestion> addQuestionToMockTest(
            @RequestParam Long mockTestId,
            @RequestParam Long mcqId,
            @RequestParam Integer questionOrder
    ) {
        MockTestQuestion created =
                mockTestQuestionService.addQuestionToMockTest(
                        mockTestId,
                        mcqId,
                        questionOrder
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }

    @GetMapping("/mock-test/{mockTestId}")
    public ResponseEntity<List<MockTestQuestion>> getQuestionsByMockTest(
            @PathVariable Long mockTestId
    ) {
        return ResponseEntity.ok(
                mockTestQuestionService
                        .getQuestionsByMockTest(mockTestId)
        );
    }
}