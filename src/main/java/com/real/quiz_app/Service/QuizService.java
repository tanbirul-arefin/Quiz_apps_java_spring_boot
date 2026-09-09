package com.real.quiz_app.Service;

import com.real.quiz_app.model.Question;
import com.real.quiz_app.model.QuestionForm;
import com.real.quiz_app.model.Result;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuizService {

    private List<Question> allQuestions;
    private List<Result> Results;

    private final QuestionInitilizer questionInitilizer;

    public QuizService(QuestionInitilizer questionInitilizer) {
        this.questionInitilizer = questionInitilizer;
    }

    @PostConstruct
    public void init() {
        allQuestions = questionInitilizer.getQuestions();
        Results = new ArrayList<>();
    }

    public QuestionForm getQuestions() {
        List<Question> allQuestionCopy = new ArrayList<>(allQuestions);
        List<Question> selectquestion = new ArrayList<>();
        Random random = new Random();
        int questionCount = Math.min(5, allQuestionCopy.size());
        for (int i = 0; i < questionCount; i++) {
            int randomNumber = random.nextInt(allQuestionCopy.size());
            selectquestion.add(allQuestionCopy.get(randomNumber));
            allQuestionCopy.remove(randomNumber);
        }
        return new QuestionForm(selectquestion);
    }

    public int getResult(QuestionForm questionForm) {
        int totalCorrect = 0;
        for (Question question : questionForm.getQuestions()) {
            Question originalQuestion = allQuestions.stream()
                    .filter(candidate -> candidate.getQuestionId() == question.getQuestionId())
                    .findFirst()
                    .orElse(null);
            if (originalQuestion != null && originalQuestion.getAns() == question.getChose()) {
                totalCorrect++;
            }
        }
        return totalCorrect;
    }

    public Result evaluateAndSaveResult(String username, QuestionForm questionForm) {
        Result result = new Result(username, getResult(questionForm));
        saveResult(result);
        return result;
    }

    public void saveResult (Result result) {
        Results.add(result);
    }

    public List<Result> getResults() {
      Results.sort((r1,r2) -> Integer.compare(r2.getTotalCorrect(), r1.getTotalCorrect()));
        return Results;
    }
}