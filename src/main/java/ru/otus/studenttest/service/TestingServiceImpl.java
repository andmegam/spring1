package ru.otus.studenttest.service;

import ru.otus.studenttest.domain.Question;
import java.util.Scanner;
public class TestingServiceImpl implements TestingService {


    private final MessageManager messageManager;
    private QuestionService qService;
    private PersonService pService;


    public TestingServiceImpl(QuestionService qService, PersonService pService, MessageManager messageManager) {
        this.qService = qService;
        this.pService = pService;
        this.messageManager = messageManager;
    }

    @Override
    public void beginTesting() {
        int countCorrectAnswer = 0;
        String userAnswer;
        int userAnswerNum;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            Question question = qService.getOneQuestion(i);
            System.out.print(messageManager.getMessage("testing.question"));
            System.out.printf(" №%d: %s %n", i + 1, question.getQuestion());
            System.out.println(messageManager.getMessage("testing.answers").concat(":"));
            int j = 1;
            for (String s : question.getAnswers()) {
                System.out.printf("%d) %s %n", j, s);
                j++;
            }

            do {
                System.out.println(messageManager.getMessage("user.answer"));
                userAnswer = scanner.nextLine().trim();

                if (userAnswer.matches("[-+]?\\d+")) {
                    userAnswerNum = Integer.valueOf(userAnswer);
                } else {
                    userAnswerNum = -1;
                    System.out.println(messageManager.getMessage("testing.exception1"));
                }
            } while ((userAnswerNum < 1) || (userAnswerNum > 3));
            if (question.getAnswers().get(userAnswerNum - 1).equals(question.getCorrectAnswer()))
                countCorrectAnswer++;
        }
        pService.getStudent().setCountCorrectAnswer(countCorrectAnswer);
    }
}
