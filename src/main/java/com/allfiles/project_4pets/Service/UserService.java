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
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private VerificationTokenService verificationTokenService;

    private final ModelMapper modelMapper;
    private final EmailSevice emailSevice;
    public UserService(UserRepository userRepository, VerificationTokenService verificationTokenService, ModelMapper modelMapper, EmailSevice emailSevice) {
        this.userRepository = userRepository;
        this.verificationTokenService = verificationTokenService;
        this.modelMapper = modelMapper;
        this.emailSevice = emailSevice;
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
        user.setEnabled(false);
        modelMapper.map(userDTO, user);
        Optional<User>saved=Optional.of(save(user));
        saved.ifPresent( u->{
            try {
                String token= UUID.randomUUID().toString();
                verificationTokenService.save(saved.get(),token);
                emailSevice.sendemail(u);
            }
            catch (Exception e){
               e.printStackTrace();
            }
        });
        return saved.get();
    }

}
