package com.highschool.backend.service;

import com.highschool.backend.entity.SchoolClass;
import com.highschool.backend.repository.SchoolClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolClassService {

    private final SchoolClassRepository schoolClassRepository;

    public SchoolClassService(SchoolClassRepository schoolClassRepository) {
        this.schoolClassRepository = schoolClassRepository;
    }

    public List<SchoolClass> getAllClasses() {
        return schoolClassRepository.findAll();
    }

    public SchoolClass getClassByNumber(Integer classNumber) {
        return schoolClassRepository
                .findByClassNumber(classNumber)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Class not found: " + classNumber
                        )
                );
    }

    public SchoolClass createClass(SchoolClass schoolClass) {

        if (schoolClassRepository
                .findByClassNumber(schoolClass.getClassNumber())
                .isPresent()) {

            throw new IllegalArgumentException(
                    "Class already exists: " + schoolClass.getClassNumber()
            );
        }

        return schoolClassRepository.save(schoolClass);
    }
}