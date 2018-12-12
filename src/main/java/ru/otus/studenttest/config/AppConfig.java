package ru.otus.studenttest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.studenttest.dao.QuestionDao;
import ru.otus.studenttest.dao.QuestionDaoImpl;
import ru.otus.studenttest.service.*;

import java.util.Locale;

@PropertySource("${property.file:application.properties}")
@Configuration
public class AppConfig {

    @Bean
    MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Bean
    QuestionDao questionDao(MessageSource messageSource, @Value("${local}") Locale local) {
        local = Locale.getDefault().toString().isEmpty() ? local : Locale.getDefault();
        String fileName = messageSource.getMessage("csvfile.url", null, local);
        return new QuestionDaoImpl(fileName);
    }

    @Bean
    QuestionService questionService(QuestionDao dao) {
        return new QuestionServiceImpl(dao);
    }

    @Bean
    PersonService personService(MessageSource messageSource, @Value("${local}") Locale local) {
        return new PersonServiceImpl(messageSource, local);
    }

    @Bean
    TestingService testingService(QuestionService questionService,
                                  PersonService personService,
                                  MessageSource messageSource,
                                  @Value("${local}") Locale local) {
        return new TestingServiceImpl(questionService, personService , messageSource, local);
    }
}
