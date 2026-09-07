package com.real.quiz_app.Service;

import com.real.quiz_app.model.Question;
import com.real.quiz_app.model.QuestionForm;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class QuizService {

       private List<Question> allQuestions;
    private final QuestionInitilizer questionInitilizer;


    @PostConstruct
    public void init() {
       //allQuestions = QuestionInitilizer.getQuestions();
    //allQuestions = QuestionInitilizer.getQuestions;
        allQuestions =questionInitilizer.getQuestions();
    }

    public QuestionForm getQuestionForm() {

        List<Question> allQuestionscopy = new ArrayList<>();
        List<Question> selectquestion = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int randomNumber = random.nextInt(allQuestions.size());
            selectquestion.add(allQuestionscopy.get(randomNumber));
            allQuestionscopy.remove(randomNumber);
        }
        return new QuestionForm(selectquestion);
    }

    public int getResult(QuestionForm questionForm) {
        int totalCorrect = 0;
        for (Question question : questionForm.getQuestions()) {
            if(question.getAns()== question.getChose()){
                totalCorrect++;
            }
        }
        return totalCorrect;
    }
}