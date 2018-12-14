package ru.otus.studenttest.service;

import ru.otus.studenttest.dao.QuestionDao;
import ru.otus.studenttest.domain.Question;


public class QuestionServiceImpl implements QuestionService {

    private QuestionDao dao;

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    @Override
    public Question getOneQuestion(int i) {
        return dao.findOneQuestion(i);
    }
}
