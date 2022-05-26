package com.allfiles.project_4pets.Service;

import com.allfiles.project_4pets.Entity.User;
import com.allfiles.project_4pets.Objects.UserDTO;
import com.allfiles.project_4pets.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserService(UserRepository URepo, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.userRepository = URepo;
    }

    public List<User> ListAll() {
        return (List<User>) userRepository.findAll();
    }

    @Transactional
    public Optional<User> findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public boolean userExists(String email){
        return findUserByEmail(email).isPresent();
    }

    @Transactional
    public User save(User user){
        return userRepository.save(user);
    }

    public User signup (UserDTO userDTO){
        User user = new User();
        modelMapper.map(userDTO, user);
        return save(user);
    }

}
