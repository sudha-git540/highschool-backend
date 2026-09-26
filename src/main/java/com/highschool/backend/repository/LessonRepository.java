package com.highschool.backend.repository;

import com.highschool.backend.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByClassSubjectIdOrderByDisplayOrderAsc(Long classSubjectId);
}