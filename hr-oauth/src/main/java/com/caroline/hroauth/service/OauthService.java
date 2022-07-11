package com.caroline.hroauth.service;

import com.caroline.hroauth.entity.User;
import com.caroline.hroauth.feingclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OauthService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User getByEmail(String email){
        return userFeignClient.getByEmail(email).getBody();
    }
}
