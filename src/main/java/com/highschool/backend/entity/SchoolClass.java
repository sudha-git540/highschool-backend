package com.highschool.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "school_classes")
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_number", nullable = false, unique = true)
    private Integer classNumber;

    public SchoolClass() {
    }

    public SchoolClass(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public Long getId() {
        return id;
    }

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }
}