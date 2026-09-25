package com.highschool.backend.controller;

import com.highschool.backend.entity.ClassSubject;
import com.highschool.backend.service.ClassSubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class-subjects")
public class ClassSubjectController {

    private final ClassSubjectService classSubjectService;

    public ClassSubjectController(
            ClassSubjectService classSubjectService) {
        this.classSubjectService = classSubjectService;
    }

    @PostMapping("/assign")
    public ResponseEntity<ClassSubject> assignSubjectToClass(
            @RequestParam Integer classNumber,
            @RequestParam Long subjectId) {

        ClassSubject classSubject =
                classSubjectService.assignSubjectToClass(
                        classNumber,
                        subjectId
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(classSubject);
    }

    @GetMapping("/{classNumber}/subjects")
    public ResponseEntity<List<ClassSubject>> getSubjectsByClass(
            @PathVariable Integer classNumber) {

        return ResponseEntity.ok(
                classSubjectService.getSubjectsByClass(classNumber)
        );
    }
}