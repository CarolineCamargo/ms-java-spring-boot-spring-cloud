package com.caroline.hroauth.controller;

import com.caroline.hroauth.entity.User;
import com.caroline.hroauth.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/oauth")
public class OauthController {

    @Autowired
    private OauthService service;

    @GetMapping(value = "/search")
    public ResponseEntity<User> getByEmail(@RequestParam String email){
        return ResponseEntity.ok(service.getByEmail(email));
    }
}
