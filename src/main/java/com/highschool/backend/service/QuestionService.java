package com.highschool.backend.service;

import com.highschool.backend.entity.Lesson;
import com.highschool.backend.entity.Question;
import com.highschool.backend.repository.LessonRepository;
import com.highschool.backend.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final LessonRepository lessonRepository;

    public QuestionService(
            QuestionRepository questionRepository,
            LessonRepository lessonRepository) {

        this.questionRepository = questionRepository;
        this.lessonRepository = lessonRepository;
    }

    public Question createQuestion(
            Long lessonId,
            Question question) {

        Lesson lesson = lessonRepository
                .findById(lessonId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Lesson not found: " + lessonId
                        ));

        question.setLesson(lesson);

        return questionRepository.save(question);
    }

    public List<Question> getQuestionsByLesson(
            Long lessonId) {

        return questionRepository.findByLessonId(lessonId);
    }

    public Question getQuestionById(Long questionId) {

        return questionRepository
                .findById(questionId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Question not found: " + questionId
                        ));
    }
}