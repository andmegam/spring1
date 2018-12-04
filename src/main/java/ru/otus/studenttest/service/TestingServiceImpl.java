package ru.otus.studenttest.service;

import ru.otus.studenttest.domain.Question;

import java.util.Scanner;

public class TestingServiceImpl implements ITestingService {

    private IQuestionService qService;
    private IPersonService pService;

    public TestingServiceImpl(IQuestionService qService, IPersonService pService) {
        this.qService = qService;
        this.pService = pService;
    }

    @Override
    public void beginTesting() {
        int countCorrectAnswer = 0;
        String userAnswer;
        int userAnswerNum;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            Question question = qService.getOneQuestion(i);
            System.out.printf("Вопрос №%d: %s %n", i + 1, question.getQuestion());
            printMessage("Варианты ответов: ");
            int j = 1;
            for (String s : question.getAnswers()) {
                System.out.printf("%d) %s %n", j, s);
                j++;
            }

            do {
                printMessage("Введите номер ответа: ");
                userAnswer = scanner.nextLine().trim();

                if (userAnswer.matches("[-+]?\\d+")) {
                    userAnswerNum = Integer.valueOf(userAnswer);
                } else {
                    userAnswerNum = -1;
                    printMessage("Необходимо ввести число от 1 до 3");
                }
            } while ((userAnswerNum < 1) || (userAnswerNum > 4));
            if (question.getAnswers().get(userAnswerNum - 1).equals(question.getCorrectAnswer()))
                countCorrectAnswer++;
        }
        pService.getStudent().setCountCorrectAnswer(countCorrectAnswer);
    }

    private void printMessage(String msg) {
        System.out.println(msg);
    }
}
