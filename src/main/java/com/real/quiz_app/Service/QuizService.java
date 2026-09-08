package com.real.quiz_app.Service;

import com.real.quiz_app.model.Question;
import com.real.quiz_app.model.QuestionForm;
import com.real.quiz_app.model.Result;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class QuizService {

    private List<Question> allQuestions;
    private List<Result> Results;

    private final QuestionInitilizer questionInitilizer;

    @PostConstruct
    public void init() {
        allQuestions = questionInitilizer.getQuestions();
        Results = new ArrayList<>();
    }

    public QuestionForm getQuestionForm() {
        List<Question> allQuestionCopy = new ArrayList<>(allQuestions);
        List<Question> selectquestion = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int randomNumber = random.nextInt(allQuestionCopy.size());
            selectquestion.add(allQuestionCopy.get(randomNumber));
            allQuestionCopy.remove(randomNumber);
        }
        return new QuestionForm(selectquestion);
    }

    public int getResult(QuestionForm questionForm) {
        int totalCorrect = 0;
        for (Question question : questionForm.getQuestions()) {
            if (question.getAns() == question.getChose()) {
                totalCorrect++;
            }
        }
        return totalCorrect;
    }

    public void saveResult (Result result) {
        Results.add(result);
    }

    public List<Result> getResults() {
      Results.sort((r1,r2) -> Integer.compare(r2.getTotalCorrect(), r1.getTotalCorrect()));
        return Results;
    }
}