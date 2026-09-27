package com.highschool.backend.service;

import com.highschool.backend.entity.Lesson;
import com.highschool.backend.entity.MCQ;
import com.highschool.backend.repository.LessonRepository;
import com.highschool.backend.repository.MCQRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MCQService {

    private final MCQRepository mcqRepository;
    private final LessonRepository lessonRepository;

    public MCQService(
            MCQRepository mcqRepository,
            LessonRepository lessonRepository
    ) {
        this.mcqRepository = mcqRepository;
        this.lessonRepository = lessonRepository;
    }

    public MCQ createMCQ(Long lessonId, MCQ mcq) {

        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Lesson not found: " + lessonId
                        )
                );

        mcq.setLesson(lesson);

        return mcqRepository.save(mcq);
    }

    public List<MCQ> getMCQsByLesson(Long lessonId) {
        return mcqRepository.findByLessonId(lessonId);
    }

    public List<MCQ> getMCQsByClass(Integer classNumber) {
        return mcqRepository
                .findByLessonClassSubjectSchoolClassClassNumber(
                        classNumber
                );
    }

    public MCQ getMCQById(Long mcqId) {
        return mcqRepository.findById(mcqId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "MCQ not found: " + mcqId
                        )
                );
    }
}