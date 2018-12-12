package ru.otus.studenttest.dao;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.studenttest.domain.Question;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class QuestionDaoImplTest {
    private static final String PATH_TO_PROPERTIES = "src/test/resources/application.properties";
    private QuestionDaoImpl questionDao;
    private Properties prop = new Properties();

    @BeforeEach
    public void setUp() {
        try (FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)) {
            prop.load(fileInputStream);
            String testFileName = prop.getProperty("csvfile.url");
            String local = prop.getProperty("local");
            questionDao = new QuestionDaoImpl(testFileName, Locale.forLanguageTag(local));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findOneQuestionTest() {
        Question question = questionDao.findOneQuestion(0);
        assertEquals("Какой размер переменной int?", question.getQuestion());
    }
}
