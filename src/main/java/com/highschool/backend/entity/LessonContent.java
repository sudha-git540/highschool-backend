package com.highschool.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lesson_contents")
public class LessonContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "lesson_id", nullable = false, unique = true)
    private Lesson lesson;

    @Column(columnDefinition = "LONGTEXT")
    private String explanation;

    @Column(columnDefinition = "LONGTEXT")
    private String summary;

    @Column(name = "important_points", columnDefinition = "LONGTEXT")
    private String importantPoints;

    public LessonContent() {
    }

    public LessonContent(
            Lesson lesson,
            String explanation,
            String summary,
            String importantPoints) {

        this.lesson = lesson;
        this.explanation = explanation;
        this.summary = summary;
        this.importantPoints = importantPoints;
    }

    public Long getId() {
        return id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImportantPoints() {
        return importantPoints;
    }

    public void setImportantPoints(String importantPoints) {
        this.importantPoints = importantPoints;
    }
}