package ru.otus.studenttest.domain;

import java.util.ArrayList;

public class Question {

    /**
     * Вопрос.
     */
    private String question;
    /**
     * Список вариантов ответов.
     */
    private ArrayList<String> answers;
    /**
     * Правильный ответ.
     */
    private String correctAnswer;

    public Question(String question, ArrayList<String> answers, String correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
