package ru.otus.studenttest.domain;

public class Person {
    private String userName;
    private String userFamily;
    private int countCorrectAnswer;

    public Person(String userName, String userFamily) {
        this.userName = userName;
        this.userFamily = userFamily;
    }

    public String getStudent() {
        return userFamily + " " + userName;
    }

    public int getCountCorrectAnswer() {
        return countCorrectAnswer;
    }

    public void setCountCorrectAnswer(int countCorrectAnswer) {
        this.countCorrectAnswer = countCorrectAnswer;
    }
}
