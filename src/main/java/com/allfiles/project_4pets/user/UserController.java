package com.allfiles.project_4pets.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService Service;

    @GetMapping("/signup")
    public String ShowSignUp(Model model) {
        model.addAttribute("User", new User());
        return "signup";
    }

    @PostMapping("/signup/save")
    public String saveUser(User user){
        userRepository.save(user);
        return "redirect:/";

    }
}
