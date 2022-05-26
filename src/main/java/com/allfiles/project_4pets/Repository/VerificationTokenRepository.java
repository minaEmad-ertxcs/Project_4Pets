package com.allfiles.project_4pets.Repository;

import com.allfiles.project_4pets.Entity.User;
import com.allfiles.project_4pets.Entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {
    VerificationToken findbytoken(String token);
    VerificationToken findbyuser(User user);
}
