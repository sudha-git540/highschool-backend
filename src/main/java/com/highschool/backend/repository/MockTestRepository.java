package com.highschool.backend.repository;

import com.highschool.backend.entity.MockTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MockTestRepository extends JpaRepository<MockTest, Long> {

    List<MockTest> findByActiveTrue();
    List<MockTest> findBySubjectIdAndActiveTrue(Long subjectId);
}