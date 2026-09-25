package com.highschool.backend.repository;

import com.highschool.backend.entity.ClassSubject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassSubjectRepository
        extends JpaRepository<ClassSubject, Long> {

    List<ClassSubject> findBySchoolClassClassNumber(Integer classNumber);
}