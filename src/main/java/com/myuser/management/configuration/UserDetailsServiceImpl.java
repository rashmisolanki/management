package com.myuser.management.configuration;

import com.myuser.management.Repositary.UserRepo;
import com.myuser.management.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.xml.ws.WebServiceRefs;
import java.util.Optional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
@Autowired
private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<UserEntity> userEntity =userRepo.findById(username);
        MyUser myUser=new MyUser(userEntity.get());
        return myUser;
    }
}
