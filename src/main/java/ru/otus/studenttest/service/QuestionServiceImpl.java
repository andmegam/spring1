package ru.otus.studenttest.service;

import ru.otus.studenttest.dao.IQuestionDao;
import ru.otus.studenttest.domain.Question;


public class QuestionServiceImpl implements IQuestionService {

    private IQuestionDao dao;

    public QuestionServiceImpl(IQuestionDao dao) {
        this.dao = dao;
    }

    @Override
    public Question getOneQuestion(int i) {
        return dao.findOneQuestion(i);
    }
}
