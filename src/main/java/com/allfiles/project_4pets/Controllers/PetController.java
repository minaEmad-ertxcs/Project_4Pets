package com.allfiles.project_4pets.Controllers;

import com.allfiles.project_4pets.Repository.PetRepository;
import com.allfiles.project_4pets.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PetController {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private UserRepository userRepository;

}
