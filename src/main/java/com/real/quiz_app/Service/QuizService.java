package com.real.quiz_app.Service;

import com.real.quiz_app.model.Question;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class QuizService {

    private List<Question> allquestions;
    private QuestionInitilizer questionInitilizer;
}
