package ru.otus.studenttest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.studenttest.domain.Person;
import ru.otus.studenttest.service.PersonServiceImpl;
import ru.otus.studenttest.service.TestingServiceImpl;

public class Application {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/context.xml");

        PersonServiceImpl personService = context.getBean(PersonServiceImpl.class);
        TestingServiceImpl testingService = context.getBean(TestingServiceImpl.class);

        personService.fillStudent();
        testingService.beginTesting();
        Person student = personService.getStudent();

        System.out.println("Студент: " + student.getStudent());
        System.out.println("Результат тестирования. Правильных ответов: " + student.getCountCorrectAnswer());

    }
}
