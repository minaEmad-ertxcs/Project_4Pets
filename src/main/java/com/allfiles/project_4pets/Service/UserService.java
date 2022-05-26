package com.allfiles.project_4pets.Service;

import com.allfiles.project_4pets.Entity.User;
import com.allfiles.project_4pets.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository URepo;

    public List<User> ListAll() {
        return (List<User>) URepo.findAll();
    }

}
