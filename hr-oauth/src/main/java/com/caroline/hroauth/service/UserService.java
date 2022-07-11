package com.caroline.hroauth.service;

import com.caroline.hroauth.entity.User;
import com.caroline.hroauth.feingclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User getByEmail(String email){
        return userFeignClient.getByEmail(email).getBody();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userFeignClient.getByEmail(email).getBody();

        if(user == null)
            throw new UsernameNotFoundException("Email not found");

        return user;
    }
}
