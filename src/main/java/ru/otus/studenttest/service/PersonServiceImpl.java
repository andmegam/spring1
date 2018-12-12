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
        //System.out.println(Locale.getDefault().toString());
        this.messageSource = messageSource;
        this.local = Locale.getDefault().toString().isEmpty() ? local : Locale.getDefault();
    }

    @Override
    public void fillStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(messageSource.getMessage("user.family", null, local));
        String userFamily = scanner.nextLine();
        System.out.println(messageSource.getMessage("user.name", null, local));
        String userName = scanner.nextLine();
        student = new Person(userFamily, userName);
        System.out.print(messageSource.getMessage("user.hello", null, local));
        System.out.println(", " + student.getStudent());
    }


    @Override
    public Person getStudent() {
        return student;
    }

    @Override
    public void testResult() {
        System.out.print(messageSource.getMessage("user.student", null, local));
        System.out.println(": " + student.getStudent());
        System.out.print(messageSource.getMessage("user.result", null, local));
        System.out.println(": " + student.getCountCorrectAnswer());
    }

}
