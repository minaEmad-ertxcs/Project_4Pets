package com.allfiles.project_4pets.Service;

import com.allfiles.project_4pets.Entity.User;
import com.allfiles.project_4pets.Entity.VerificationToken;
import com.allfiles.project_4pets.Repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Calendar;

@Service
public class VerificationTokenService {
    private final VerificationTokenRepository verificationTokenRepository;
@Autowired
    public VerificationTokenService(VerificationTokenRepository verificationTokenRepository) {
        this.verificationTokenRepository = verificationTokenRepository;
    }
    @Transactional
    public VerificationToken findbytoken(String token){
     VerificationTokenRepository vtr = null;
    return vtr.findbytoken(token);
    }
    @Transactional
    public VerificationToken findbyuser(User user){
    VerificationTokenRepository vtr = null;
    return vtr.findbyuser(user);
    }
    @Transactional
    public void save(User user,String token){
    VerificationToken verificationToken=new VerificationToken(token,user);
    verificationToken.setExpiry_date(calculateExpiryDate(24*68));
    verificationTokenRepository.save(verificationToken);
    }
    private Timestamp calculateExpiryDate(int expirytimeminute){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.MINUTE,expirytimeminute);
        return new Timestamp(cal.getTime().getTime());
    }
}
