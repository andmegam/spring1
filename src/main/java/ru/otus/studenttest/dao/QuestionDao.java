package ru.otus.studenttest.dao;

import ru.otus.studenttest.domain.Question;


public interface QuestionDao {
    Question findOneQuestion(int index);
}
