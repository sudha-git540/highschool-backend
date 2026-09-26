package com.highschool.backend.service;

import com.highschool.backend.entity.ClassSubject;
import com.highschool.backend.entity.Lesson;
import com.highschool.backend.repository.ClassSubjectRepository;
import com.highschool.backend.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;
    private final ClassSubjectRepository classSubjectRepository;

    public LessonService(
            LessonRepository lessonRepository,
            ClassSubjectRepository classSubjectRepository) {

        this.lessonRepository = lessonRepository;
        this.classSubjectRepository = classSubjectRepository;
    }

    public Lesson createLesson(
            Long classSubjectId,
            Lesson lesson) {

        ClassSubject classSubject = classSubjectRepository
                .findById(classSubjectId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Class-Subject mapping not found: "
                                        + classSubjectId
                        ));

        lesson.setClassSubject(classSubject);

        return lessonRepository.save(lesson);
    }

    public List<Lesson> getLessonsByClassSubject(
            Long classSubjectId) {

        return lessonRepository
                .findByClassSubjectIdOrderByDisplayOrderAsc(
                        classSubjectId
                );
    }

    public Lesson getLessonById(Long lessonId) {

        return lessonRepository
                .findById(lessonId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Lesson not found: " + lessonId
                        ));
    }
}