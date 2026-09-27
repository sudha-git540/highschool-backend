package com.highschool.backend.controller;

import com.highschool.backend.entity.MCQ;
import com.highschool.backend.service.MCQService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mcqs")
public class MCQController {

    private final MCQService mcqService;

    public MCQController(MCQService mcqService) {
        this.mcqService = mcqService;
    }

    @PostMapping("/lesson/{lessonId}")
    public ResponseEntity<MCQ> createMCQ(
            @PathVariable Long lessonId,
            @RequestBody MCQ mcq
    ) {
        MCQ createdMCQ = mcqService.createMCQ(
                lessonId,
                mcq
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdMCQ);
    }

    @GetMapping("/lesson/{lessonId}")
    public ResponseEntity<List<MCQ>> getMCQsByLesson(
            @PathVariable Long lessonId
    ) {
        return ResponseEntity.ok(
                mcqService.getMCQsByLesson(lessonId)
        );
    }

    @GetMapping("/class/{classNumber}")
    public ResponseEntity<List<MCQ>> getMCQsByClass(
            @PathVariable Integer classNumber
    ) {
        return ResponseEntity.ok(
                mcqService.getMCQsByClass(classNumber)
        );
    }

    @GetMapping("/{mcqId}")
    public ResponseEntity<MCQ> getMCQById(
            @PathVariable Long mcqId
    ) {
        return ResponseEntity.ok(
                mcqService.getMCQById(mcqId)
        );
    }
}