package com.highschool.backend.controller;

import com.highschool.backend.entity.MockTest;
import com.highschool.backend.service.MockTestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mock-tests")
public class MockTestController {

    private final MockTestService mockTestService;

    public MockTestController(MockTestService mockTestService) {
        this.mockTestService = mockTestService;
    }

    @PostMapping
    public ResponseEntity<MockTest> createMockTest(
            @RequestBody MockTest mockTest
    ) {
        MockTest createdMockTest =
                mockTestService.createMockTest(mockTest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdMockTest);
    }

    @GetMapping
    public ResponseEntity<List<MockTest>> getActiveMockTests() {
        return ResponseEntity.ok(
                mockTestService.getActiveMockTests()
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<MockTest>> getAllMockTests() {
        return ResponseEntity.ok(
                mockTestService.getAllMockTests()
        );
    }

    @GetMapping("/{mockTestId}")
    public ResponseEntity<MockTest> getMockTestById(
            @PathVariable Long mockTestId
    ) {
        return ResponseEntity.ok(
                mockTestService.getMockTestById(mockTestId)
        );
    }
    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<List<MockTest>> getMockTestsBySubject(
            @PathVariable Long subjectId) {

        return ResponseEntity.ok(
                mockTestService.getActiveMockTestsBySubject(subjectId)
        );
    }
    @PutMapping("/{mockTestId}/subject/{subjectId}")
    public ResponseEntity<MockTest> assignSubjectToMockTest(
            @PathVariable Long mockTestId,
            @PathVariable Long subjectId) {

        return ResponseEntity.ok(
                mockTestService.assignSubjectToMockTest(
                        mockTestId,
                        subjectId
                )
        );
    }

}