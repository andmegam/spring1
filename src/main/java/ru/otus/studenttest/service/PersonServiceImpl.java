package ru.otus.studenttest.service;

import ru.otus.studenttest.domain.Person;

import java.util.Scanner;

public class PersonServiceImpl implements IPersonService {
    private Person student;

    @Override
    public void fillStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите Вашу фамилию...");
        String userFamily = scanner.nextLine();
        System.out.println("Введите Ваше имя...");
        String userName = scanner.nextLine();
        student = new Person(userFamily, userName);
        System.out.println("Здравствуйте, " + student.getStudent());
    }

    @Override
    public Person getStudent() {
        return student;
    }
}
