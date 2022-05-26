package com.allfiles.project_4pets.Repository;

import com.allfiles.project_4pets.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findUserByEmail(String email);
}
