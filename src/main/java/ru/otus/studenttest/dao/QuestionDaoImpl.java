package ru.otus.studenttest.dao;

import au.com.bytecode.opencsv.CSVReader;
import ru.otus.studenttest.domain.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class QuestionDaoImpl implements IQuestionDao {

    private final String fileName;

    public QuestionDaoImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Question findOneQuestion(int index){
        String question = "";
        String correctAnswer = "";
        ArrayList<String> answers = new ArrayList<>();

        File file = new File("src/main/resources/"+fileName);
        try (CSVReader csvReader = new CSVReader(new FileReader(file), ';', '"', 0)) {
            String[] nextLine;
            int i = 0;
            while ((nextLine = csvReader.readNext()) != null) {
                if (i == index) {
                    question = nextLine[0];
                    correctAnswer = nextLine[1];
                    answers.addAll(Arrays.asList(nextLine[2], nextLine[3], nextLine[4]));
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Question(question, answers, correctAnswer);
    }
}
