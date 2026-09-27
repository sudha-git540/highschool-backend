package com.highschool.backend.service;

import com.highschool.backend.entity.Lesson;
import com.highschool.backend.entity.MCQAttempt;
import com.highschool.backend.entity.Student;
import com.highschool.backend.repository.LessonRepository;
import com.highschool.backend.repository.MCQAttemptRepository;
import com.highschool.backend.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MCQAttemptService {

    private final MCQAttemptRepository mcqAttemptRepository;
    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;

    public MCQAttemptService(
            MCQAttemptRepository mcqAttemptRepository,
            StudentRepository studentRepository,
            LessonRepository lessonRepository
    ) {
        this.mcqAttemptRepository = mcqAttemptRepository;
        this.studentRepository = studentRepository;
        this.lessonRepository = lessonRepository;
    }

    public MCQAttempt saveAttempt(
            String studentId,
            Long lessonId,
            Integer totalQuestions,
            Integer correctAnswers
    ) {

        Student student = studentRepository
                .findByStudentId(studentId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Student not found: " + studentId
                        )
                );

        Lesson lesson = lessonRepository
                .findById(lessonId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Lesson not found: " + lessonId
                        )
                );

        Integer wrongAnswers =
                totalQuestions - correctAnswers;

        Double percentage =
                totalQuestions == 0
                        ? 0.0
                        : (correctAnswers * 100.0)
                        / totalQuestions;

        MCQAttempt attempt = new MCQAttempt();

        attempt.setStudent(student);
        attempt.setLesson(lesson);
        attempt.setTotalQuestions(totalQuestions);
        attempt.setCorrectAnswers(correctAnswers);
        attempt.setWrongAnswers(wrongAnswers);
        attempt.setScore(correctAnswers);
        attempt.setPercentage(percentage);
        attempt.setCompletedAt(LocalDateTime.now());

        return mcqAttemptRepository.save(attempt);
    }

    public List<MCQAttempt> getStudentAttempts(
            String studentId
    ) {
        return mcqAttemptRepository
                .findByStudentStudentIdOrderByCompletedAtDesc(
                        studentId
                );
    }

    public List<MCQAttempt> getLessonAttempts(
            String studentId,
            Long lessonId
    ) {
        return mcqAttemptRepository
                .findByStudentStudentIdAndLessonIdOrderByCompletedAtDesc(
                        studentId,
                        lessonId
                );
    }
}