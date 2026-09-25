package com.highschool.backend.service;

import com.highschool.backend.entity.ClassSubject;
import com.highschool.backend.entity.SchoolClass;
import com.highschool.backend.entity.Subject;
import com.highschool.backend.repository.ClassSubjectRepository;
import com.highschool.backend.repository.SchoolClassRepository;
import com.highschool.backend.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassSubjectService {

    private final ClassSubjectRepository classSubjectRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final SubjectRepository subjectRepository;

    public ClassSubjectService(
            ClassSubjectRepository classSubjectRepository,
            SchoolClassRepository schoolClassRepository,
            SubjectRepository subjectRepository) {

        this.classSubjectRepository = classSubjectRepository;
        this.schoolClassRepository = schoolClassRepository;
        this.subjectRepository = subjectRepository;
    }

    public ClassSubject assignSubjectToClass(
            Integer classNumber,
            Long subjectId) {

        SchoolClass schoolClass = schoolClassRepository
                .findByClassNumber(classNumber)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Class not found: " + classNumber
                        ));

        Subject subject = subjectRepository
                .findById(subjectId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Subject not found: " + subjectId
                        ));

        ClassSubject classSubject =
                new ClassSubject(schoolClass, subject);

        return classSubjectRepository.save(classSubject);
    }

    public List<ClassSubject> getSubjectsByClass(
            Integer classNumber) {

        return classSubjectRepository
                .findBySchoolClassClassNumber(classNumber);
    }
}