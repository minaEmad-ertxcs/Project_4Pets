package com.allfiles.project_4pets.Repository;

import com.allfiles.project_4pets.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
