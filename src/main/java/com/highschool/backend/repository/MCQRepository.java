package com.highschool.backend.repository;

import com.highschool.backend.entity.MCQ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MCQRepository extends JpaRepository<MCQ, Long> {

    List<MCQ> findByLessonId(Long lessonId);

    List<MCQ> findByLessonClassSubjectSchoolClassClassNumber(
            Integer classNumber
    );
}