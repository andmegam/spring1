package ru.otus.studenttest.service;

import org.junit.Before;
import org.junit.Test;
import ru.otus.studenttest.dao.QuestionDaoImpl;
import ru.otus.studenttest.domain.Question;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QuestionServiceImplTest {
    private final String fileName= "questions.csv";
    private QuestionDaoImpl questionDao;


    @Before
    public void beforeTest() {
        questionDao = new QuestionDaoImpl(fileName);
    }

    @Test
    public void getOneQuestionTest() {
        Question question = questionDao.findOneQuestion(0);
        assertThat("Какой размер переменной int?", is(question.getQuestion()));
        assertThat("32 bit", is(question.getCorrectAnswer()));
    }
}
