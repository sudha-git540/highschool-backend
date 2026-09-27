package com.highschool.backend.service;

import com.highschool.backend.entity.MockTest;
import com.highschool.backend.entity.Subject;
import com.highschool.backend.repository.MockTestRepository;
import com.highschool.backend.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockTestService {

    private final MockTestRepository mockTestRepository;
    private final SubjectRepository subjectRepository;

    public MockTestService(
            MockTestRepository mockTestRepository,
            SubjectRepository subjectRepository) {

        this.mockTestRepository = mockTestRepository;
        this.subjectRepository = subjectRepository;
    }

    public MockTest createMockTest(MockTest mockTest) {
        return mockTestRepository.save(mockTest);
    }

    public List<MockTest> getActiveMockTests() {
        return mockTestRepository.findByActiveTrue();
    }

    public List<MockTest> getAllMockTests() {
        return mockTestRepository.findAll();
    }

    public MockTest getMockTestById(Long mockTestId) {
        return mockTestRepository.findById(mockTestId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Mock test not found: " + mockTestId
                        )
                );
    }

    public List<MockTest> getActiveMockTestsBySubject(Long subjectId) {
        return mockTestRepository.findBySubjectIdAndActiveTrue(subjectId);
    }

    public MockTest assignSubjectToMockTest(
            Long mockTestId,
            Long subjectId) {

        MockTest mockTest = mockTestRepository.findById(mockTestId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Mock test not found: " + mockTestId
                        )
                );

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Subject not found: " + subjectId
                        )
                );

        mockTest.setSubject(subject);

        return mockTestRepository.save(mockTest);
    }
}