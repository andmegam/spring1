package ru.otus.studenttest.service;

import org.springframework.context.MessageSource;
import ru.otus.studenttest.domain.Question;

import java.util.Locale;
import java.util.Scanner;

public class TestingServiceImpl implements TestingService {

    private final MessageSource messageSource;
    private final Locale local;
    private QuestionService qService;
    private PersonService pService;


    public TestingServiceImpl(QuestionService qService, PersonService pService, MessageSource messageSource, Locale local) {
        this.qService = qService;
        this.pService = pService;
        this.messageSource = messageSource;
        this.local = local;
    }

    @Override
    public void beginTesting() {
        int countCorrectAnswer = 0;
        String userAnswer;
        int userAnswerNum;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            Question question = qService.getOneQuestion(i);
            System.out.print(messageSource.getMessage("testing.question", null, local));
            System.out.printf(" №%d: %s %n", i + 1, question.getQuestion());
            System.out.println(messageSource.getMessage("testing.answers", null, local).concat(":"));
            int j = 1;
            for (String s : question.getAnswers()) {
                System.out.printf("%d) %s %n", j, s);
                j++;
            }

            do {
                System.out.println(messageSource.getMessage("user.answer", null, local));
                userAnswer = scanner.nextLine().trim();

                if (userAnswer.matches("[-+]?\\d+")) {
                    userAnswerNum = Integer.valueOf(userAnswer);
                } else {
                    userAnswerNum = -1;
                    System.out.println(messageSource.getMessage("testing.exception1", null, local));
                }
            } while ((userAnswerNum < 1) || (userAnswerNum > 3));
            if (question.getAnswers().get(userAnswerNum - 1).equals(question.getCorrectAnswer()))
                countCorrectAnswer++;
        }
        pService.getStudent().setCountCorrectAnswer(countCorrectAnswer);
    }
}
