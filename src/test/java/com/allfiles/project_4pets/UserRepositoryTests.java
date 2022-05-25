package com.allfiles.project_4pets;

import com.allfiles.project_4pets.user.User;
import com.allfiles.project_4pets.user.UserRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired private UserRepository userRepository;

    @Test
    public void testAddNew(){
        User user1=new User();

        user1.setFirstName("marina");
        user1.setLastName("joseph");
        user1.setEmail("martina@sdf.com");
        user1.setPhone("010");
        user1.setPassword("1234");
        user1.setDateOfBirth("02/26/2001");
        user1.setGender("Female");
        User savedUser1 = userRepository.save(user1);

        Assertions.assertThat(savedUser1).isNotNull();
        Assertions.assertThat(savedUser1.getID()).isGreaterThan(0);


    }
    @Test
    public void TestListAll(){
        Iterable<User>users=userRepository.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for(User user:users){
            System.out.println(user);
        }
    }
}
