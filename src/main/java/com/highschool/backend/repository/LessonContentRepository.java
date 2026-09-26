package com.highschool.backend.repository;

import com.highschool.backend.entity.LessonContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LessonContentRepository extends JpaRepository<LessonContent, Long> {

    Optional<LessonContent> findByLessonId(Long lessonId);
}