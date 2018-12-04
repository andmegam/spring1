package ru.otus.studenttest.dao;

import ru.otus.studenttest.domain.Question;


public interface IQuestionDao {
    Question findOneQuestion(int index);
}
