package com.highschool.backend.service;

import com.highschool.backend.entity.MCQ;
import com.highschool.backend.entity.MockTest;
import com.highschool.backend.entity.MockTestQuestion;
import com.highschool.backend.repository.MCQRepository;
import com.highschool.backend.repository.MockTestQuestionRepository;
import com.highschool.backend.repository.MockTestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockTestQuestionService {

    private final MockTestQuestionRepository mockTestQuestionRepository;
    private final MockTestRepository mockTestRepository;
    private final MCQRepository mcqRepository;

    public MockTestQuestionService(
            MockTestQuestionRepository mockTestQuestionRepository,
            MockTestRepository mockTestRepository,
            MCQRepository mcqRepository
    ) {
        this.mockTestQuestionRepository = mockTestQuestionRepository;
        this.mockTestRepository = mockTestRepository;
        this.mcqRepository = mcqRepository;
    }

    public MockTestQuestion addQuestionToMockTest(
            Long mockTestId,
            Long mcqId,
            Integer questionOrder
    ) {
        MockTest mockTest = mockTestRepository
                .findById(mockTestId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Mock test not found: " + mockTestId
                        )
                );

        MCQ mcq = mcqRepository
                .findById(mcqId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "MCQ not found: " + mcqId
                        )
                );

        MockTestQuestion mockTestQuestion =
                new MockTestQuestion();

        mockTestQuestion.setMockTest(mockTest);
        mockTestQuestion.setMcq(mcq);
        mockTestQuestion.setQuestionOrder(questionOrder);

        return mockTestQuestionRepository.save(
                mockTestQuestion
        );
    }

    public List<MockTestQuestion> getQuestionsByMockTest(
            Long mockTestId
    ) {
        return mockTestQuestionRepository
                .findByMockTestIdOrderByQuestionOrderAsc(
                        mockTestId
                );
    }
}