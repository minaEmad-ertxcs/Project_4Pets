package com.allfiles.project_4pets.pet;

import com.allfiles.project_4pets.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class PetController {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private UserRepository userRepository;

}
