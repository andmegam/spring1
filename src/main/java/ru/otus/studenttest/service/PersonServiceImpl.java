package ru.otus.studenttest.service;

import ru.otus.studenttest.domain.Person;
import java.util.Scanner;

public class PersonServiceImpl implements PersonService {
    private final MessageManager messageManager;
    private Person student;

    public PersonServiceImpl(MessageManager messageManager) {
        this.messageManager = messageManager;
    }

    @Override
    public void fillStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(messageManager.getMessage("user.family"));
        String userFamily = scanner.nextLine();
        System.out.println(messageManager.getMessage("user.name"));
        String userName = scanner.nextLine();
        student = new Person(userFamily, userName);
        System.out.print(messageManager.getMessage("user.hello"));
        System.out.println(", " + student.getStudent());
    }


    @Override
    public Person getStudent() {
        return student;
    }

    @Override
    public void testResult() {
        System.out.print(messageManager.getMessage("user.student"));
        System.out.println(": " + student.getStudent());
        System.out.print(messageManager.getMessage("user.result"));
        System.out.println(": " + student.getCountCorrectAnswer());
    }

}
