package ru.otus.studenttest.service;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class MessageManagerImpl implements MessageManager {

    private final MessageSource messageSource;
    private final Locale locale;

    public MessageManagerImpl(MessageSource messageSource, Locale locale) {
        this.messageSource = messageSource;
        this.locale = locale;
    }

    @Override
    public String getMessage(String msgKey) {
        return messageSource.getMessage(msgKey, null, locale);
    }

}
