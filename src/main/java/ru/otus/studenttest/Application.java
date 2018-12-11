package ru.otus.studenttest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.studenttest.service.PersonServiceImpl;
import ru.otus.studenttest.service.TestingServiceImpl;


@ComponentScan
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext
                context = new AnnotationConfigApplicationContext(Application.class);

        PersonServiceImpl personService = context.getBean(PersonServiceImpl.class);
        TestingServiceImpl testingService = context.getBean(TestingServiceImpl.class);

        personService.fillStudent();
        testingService.beginTesting();
        personService.testResult();
    }
}
