package com.highschool.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String questionText;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuestionType type;

    @Column(name = "is_important", nullable = false)
    private Boolean important;

    @Column(name = "is_previous_exam", nullable = false)
    private Boolean previousExam;

    @Column(name = "exam_year")
    private Integer examYear;

    @Column(name = "exam_source")
    private String examSource;

    public Question() {
    }

    public Question(
            Lesson lesson,
            String questionText,
            QuestionType type,
            Boolean important,
            Boolean previousExam,
            Integer examYear,
            String examSource) {

        this.lesson = lesson;
        this.questionText = questionText;
        this.type = type;
        this.important = important;
        this.previousExam = previousExam;
        this.examYear = examYear;
        this.examSource = examSource;
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

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public Boolean getImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }

    public Boolean getPreviousExam() {
        return previousExam;
    }

    public void setPreviousExam(Boolean previousExam) {
        this.previousExam = previousExam;
    }

    public Integer getExamYear() {
        return examYear;
    }

    public void setExamYear(Integer examYear) {
        this.examYear = examYear;
    }

    public String getExamSource() {
        return examSource;
    }

    public void setExamSource(String examSource) {
        this.examSource = examSource;
    }
}