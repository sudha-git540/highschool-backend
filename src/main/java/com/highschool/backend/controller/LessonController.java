package com.highschool.backend.controller;

import com.highschool.backend.entity.Lesson;
import com.highschool.backend.service.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping("/class-subject/{classSubjectId}")
    public ResponseEntity<Lesson> createLesson(
            @PathVariable Long classSubjectId,
            @RequestBody Lesson lesson) {

        Lesson createdLesson =
                lessonService.createLesson(
                        classSubjectId,
                        lesson
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdLesson);
    }

    @GetMapping("/class-subject/{classSubjectId}")
    public ResponseEntity<List<Lesson>> getLessonsByClassSubject(
            @PathVariable Long classSubjectId) {

        return ResponseEntity.ok(
                lessonService.getLessonsByClassSubject(
                        classSubjectId
                )
        );
    }

    @GetMapping("/{lessonId}")
    public ResponseEntity<Lesson> getLessonById(
            @PathVariable Long lessonId) {

        return ResponseEntity.ok(
                lessonService.getLessonById(lessonId)
        );
    }
}