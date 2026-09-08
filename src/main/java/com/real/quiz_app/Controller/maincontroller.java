package com.real.quiz_app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class maincontroller {

    @GetMapping("/")
    public String home_page(){
        return "home-page";
    }
}
