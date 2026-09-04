package com.real.quiz_app.Service;

import com.real.quiz_app.model.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class QuestionInitilizer {
    private List<Question> questionForm;

    @PostConstruct
    public void init() {
        questionForm = new ArrayList<>();

        questionForm.add(new Question(1,
                  "what is a correct syntax to output \"Hello World\" in java?",
                "echo \"Hello World\"",
                "printf(\"Hello World\")",
                "system.out.ptintln(\"Hello World\")",
                3,-1));
    }
}
