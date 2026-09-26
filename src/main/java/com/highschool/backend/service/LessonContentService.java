package com.highschool.backend.service;

import com.highschool.backend.entity.Lesson;
import com.highschool.backend.entity.LessonContent;
import com.highschool.backend.repository.LessonContentRepository;
import com.highschool.backend.repository.LessonRepository;
import org.springframework.stereotype.Service;

@Service
public class LessonContentService {

    private final LessonContentRepository lessonContentRepository;
    private final LessonRepository lessonRepository;

    public LessonContentService(
            LessonContentRepository lessonContentRepository,
            LessonRepository lessonRepository) {

        this.lessonContentRepository = lessonContentRepository;
        this.lessonRepository = lessonRepository;
    }

    public LessonContent createLessonContent(
            Long lessonId,
            LessonContent lessonContent) {

        Lesson lesson = lessonRepository
                .findById(lessonId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Lesson not found: " + lessonId
                        ));

        if (lessonContentRepository
                .findByLessonId(lessonId)
                .isPresent()) {

            throw new IllegalArgumentException(
                    "Content already exists for lesson: " + lessonId
            );
        }

        lessonContent.setLesson(lesson);

        return lessonContentRepository.save(lessonContent);
    }

    public LessonContent getLessonContent(Long lessonId) {

        return lessonContentRepository
                .findByLessonId(lessonId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Content not found for lesson: " + lessonId
                        ));
    }
}