package ru.otus.studenttest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.studenttest.dao.QuestionDao;
import ru.otus.studenttest.dao.QuestionDaoImpl;
import ru.otus.studenttest.service.*;

import java.util.Locale;

@PropertySource("${property.file:application.properties}")
@Configuration
public class AppConfig {


    @Bean
    MessageManager messageManager(@Value("${local}") Locale local) {
        return new MessageManagerImpl(local);
    }

    @Bean
    PersonService personService(MessageManager messageManager) {
        return new PersonServiceImpl(messageManager);
    }

    @Bean
    QuestionDao questionDao(@Value("${csvfile.url}") String filename) {
        return new QuestionDaoImpl(filename);
    }

    @Bean
    QuestionService questionService(QuestionDao dao) {
        return new QuestionServiceImpl(dao);
    }


    @Bean
    TestingService testingService(QuestionService questionService,
                                  PersonService personService,
                                  MessageManager messageManager) {
        return new TestingServiceImpl(questionService, personService, messageManager);
    }
}
