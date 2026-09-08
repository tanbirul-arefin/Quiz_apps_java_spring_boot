//package com.real.quiz_app.Controller;
//
//import com.real.quiz_app.model.QuestionForm;
//import com.real.quiz_app.Service.QuizService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class QuizController {
//
//    private final QuizService quizService;
//
//    public QuizController(QuizService quizService) {
//        this.quizService = quizService;
//    }
//
//    @GetMapping("/")
//    public String showQuiz(Model model) {
//        model.addAttribute("questionForm", quizService.getQuestionForm());
//        return "quiz";
//    }
//
//    @PostMapping("/result")
//    public String showResult(@ModelAttribute QuestionForm questionForm, Model model) {
//        int totalCorrect = quizService.getResult(questionForm);
//        int totalQuestions = questionForm.getQuestions().size();
//        model.addAttribute("totalCorrect", totalCorrect);
//        model.addAttribute("totalQuestions", totalQuestions);
//        model.addAttribute("questionForm", questionForm);
//        return "result";
//    }
//
//    @GetMapping("/restart")
//    public String restart() {
//        return "redirect:/";
//    }
//}