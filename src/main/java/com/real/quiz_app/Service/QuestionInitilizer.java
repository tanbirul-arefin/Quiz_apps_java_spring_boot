package com.real.quiz_app.Service;

import com.real.quiz_app.model.Question;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service

public class QuestionInitilizer {
    private List<Question> questions;

    @PostConstruct
    public void init() {
        questions = new ArrayList<>();

        questions.add(new Question(1,
                "How do you create a variable with the numeric value 5?",
                "num x = 5;",
                "float x = 5;",
                "int x = 5;",
                3, -1));

        questions.add(new Question(2,
                "Which data type is used to create a variable that should store text?",
                "String",
                "myString",
                "Txt",
                1, -1));

        questions.add(new Question(3,
                "How do you insert single-line comments in Java?",
                "// This is a comment",
                "/* This is a comment",
                "# This is a comment",
                1, -1));

        questions.add(new Question(4,
                "Which operator is used to add together two values?",
                "*",
                "+",
                "&",
                2, -1));

        questions.add(new Question(5,
                "Which of these is a correct way to create an object in Java?",
                "MyClass obj = new MyClass();",
                "class MyClass = new();",
                "new MyClass obj;",
                1, -1));

        questions.add(new Question(6,
                "What is the size of an int variable in Java?",
                "8 bit",
                "32 bit",
                "16 bit",
                2, -1));

        questions.add(new Question(7,
                "Which keyword is used to return a value inside a method?",
                "get",
                "break",
                "return",
                3, -1));

        questions.add(new Question(8,
                "Java array indexes start with:",
                "0",
                "1",
                "-1",
                1, -1));

        questions.add(new Question(9,
                "Which method can be used to find the length of a string?",
                "getSize()",
                "length()",
                "len()",
                2, -1));

        questions.add(new Question(10,
                "Which keyword is used to inherit a class in Java?",
                "implements",
                "extends",
                "inherits",
                2, -1));
    }
}
