package ru.otus.studenttest.service;

import org.springframework.context.MessageSource;
import ru.otus.studenttest.domain.Person;

import java.util.Locale;
import java.util.Scanner;

public class PersonServiceImpl implements PersonService {
    private final MessageSource messageSource;
    private final Locale local;
    private Person student;


    public PersonServiceImpl(MessageSource messageSource, Locale local) {
        this.messageSource = messageSource;
        this.local = local;
    }

    @Override
    public void fillStudent() {
        Scanner scanner = new Scanner(System.in);

        printMessage("user.family", true);
        String userFamily = scanner.nextLine();
        printMessage("user.name", true);
        String userName = scanner.nextLine();
        student = new Person(userFamily, userName);
        printMessage("user.hello", false);
        System.out.println(", " + student.getStudent());
    }


    @Override
    public Person getStudent() {
        return student;
    }

    @Override
    public void testResult() {
        printMessage("user.student", false);
        System.out.println(": " + student.getStudent());
        printMessage("user.result", false);
        System.out.println(": " + student.getCountCorrectAnswer());
    }

    private void printMessage(String mes, boolean newLine) {
        System.out.print(messageSource.getMessage(mes, null, local));
        if (newLine)
            System.out.println();
    }

}
