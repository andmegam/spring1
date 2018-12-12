package ru.otus.studenttest.dao;

import org.springframework.cglib.core.Local;
import ru.otus.studenttest.domain.Question;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;


public class QuestionDaoImpl implements QuestionDao {

    private String fileNameLocal;

    public QuestionDaoImpl(String fileName, Locale local) {
        setFile(fileName, local);
    }

    private void setFile(String fileName, Locale local) {
        String f = Locale.getDefault().toString().isEmpty() ? "ru_RU" : Locale.getDefault().toString() ;
        this.fileNameLocal = fileName.concat("_").concat(f).concat(".csv");
    }

    @Override
    public Question findOneQuestion(int index) {
        String question = "";
        String correctAnswer = "";
        ArrayList<String> answers = new ArrayList<>();

        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(fileNameLocal);
        int i = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8))) {
            for (String line; (line = reader.readLine()) != null; ) {
                String[] questionParts = line.split(";");
                if (questionParts.length < 3) {
                    continue;
                }
                if (i == index) {
                    question = questionParts[0];
                    correctAnswer = questionParts[1];
                    answers.addAll(Arrays.asList(questionParts[2], questionParts[3], questionParts[4]));
                    break;
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Question(question, answers, correctAnswer);
    }
}
