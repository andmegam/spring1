package ru.otus.studenttest.service;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

public class MessageManagerImpl implements MessageManager {

    private MessageSource messageSource;
    private final Locale locale;

    public MessageManagerImpl(Locale locale) {
        this.locale = locale;
        setMessageSource();
    }

    private void setMessageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/bundle");
        ms.setDefaultEncoding("UTF-8");
        this.messageSource = ms;
    }


    @Override
    public String getMessage(String msgKey) {
        return messageSource.getMessage(msgKey, null, locale);
    }

}
