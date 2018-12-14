package ru.otus.studenttest.dao;

import ru.otus.studenttest.domain.Question;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class QuestionDaoImpl implements QuestionDao {

    private final String fileName;

    public QuestionDaoImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Question findOneQuestion(int index) {
        String question = "";
        String correctAnswer = "";
        ArrayList<String> answers = new ArrayList<>();

        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(fileName);
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
