package com.highschool.backend.repository;

import com.highschool.backend.entity.MCQAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MCQAttemptRepository
        extends JpaRepository<MCQAttempt, Long> {

    List<MCQAttempt> findByStudentStudentIdOrderByCompletedAtDesc(
            String studentId
    );

    List<MCQAttempt> findByStudentStudentIdAndLessonIdOrderByCompletedAtDesc(
            String studentId,
            Long lessonId
    );
}