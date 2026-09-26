package com.highschool.backend.controller;

import com.highschool.backend.entity.LessonContent;
import com.highschool.backend.service.LessonContentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lesson-content")
public class LessonContentController {

    private final LessonContentService lessonContentService;

    public LessonContentController(
            LessonContentService lessonContentService) {
        this.lessonContentService = lessonContentService;
    }

    @PostMapping("/lesson/{lessonId}")
    public ResponseEntity<LessonContent> createLessonContent(
            @PathVariable Long lessonId,
            @RequestBody LessonContent lessonContent) {

        LessonContent createdContent =
                lessonContentService.createLessonContent(
                        lessonId,
                        lessonContent
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdContent);
    }

    @GetMapping("/lesson/{lessonId}")
    public ResponseEntity<LessonContent> getLessonContent(
            @PathVariable Long lessonId) {

        return ResponseEntity.ok(
                lessonContentService.getLessonContent(lessonId)
        );
    }
}