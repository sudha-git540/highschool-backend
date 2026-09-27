package com.highschool.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "mock_test_questions",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"mock_test_id", "mcq_id"}
                )
        }
)
public class MockTestQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mock_test_id", nullable = false)
    private MockTest mockTest;

    @ManyToOne
    @JoinColumn(name = "mcq_id", nullable = false)
    private MCQ mcq;

    @Column(name = "question_order", nullable = false)
    private Integer questionOrder;

    public MockTestQuestion() {
    }

    public MockTestQuestion(
            MockTest mockTest,
            MCQ mcq,
            Integer questionOrder
    ) {
        this.mockTest = mockTest;
        this.mcq = mcq;
        this.questionOrder = questionOrder;
    }

    public Long getId() {
        return id;
    }

    public MockTest getMockTest() {
        return mockTest;
    }

    public void setMockTest(MockTest mockTest) {
        this.mockTest = mockTest;
    }

    public MCQ getMcq() {
        return mcq;
    }

    public void setMcq(MCQ mcq) {
        this.mcq = mcq;
    }

    public Integer getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(Integer questionOrder) {
        this.questionOrder = questionOrder;
    }
}