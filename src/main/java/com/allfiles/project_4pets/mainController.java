package com.allfiles.project_4pets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {

    @GetMapping("")
    public String showHomePage() {
        return "login.html";
    }
}
