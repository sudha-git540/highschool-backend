package com.highschool.backend.controller;

import com.highschool.backend.entity.SchoolClass;
import com.highschool.backend.service.SchoolClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class SchoolClassController {

    private final SchoolClassService schoolClassService;

    public SchoolClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    @GetMapping
    public ResponseEntity<List<SchoolClass>> getAllClasses() {
        return ResponseEntity.ok(
                schoolClassService.getAllClasses()
        );
    }

    @GetMapping("/{classNumber}")
    public ResponseEntity<SchoolClass> getClassByNumber(
            @PathVariable Integer classNumber) {

        return ResponseEntity.ok(
                schoolClassService.getClassByNumber(classNumber)
        );
    }

    @PostMapping
    public ResponseEntity<SchoolClass> createClass(
            @RequestBody SchoolClass schoolClass) {

        SchoolClass createdClass =
                schoolClassService.createClass(schoolClass);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdClass);
    }
}