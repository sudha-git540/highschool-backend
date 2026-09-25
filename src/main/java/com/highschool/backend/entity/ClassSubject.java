package com.highschool.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "class_subjects",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"class_id", "subject_id"}
                )
        }
)
public class ClassSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private SchoolClass schoolClass;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    public ClassSubject() {
    }

    public ClassSubject(SchoolClass schoolClass, Subject subject) {
        this.schoolClass = schoolClass;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}