package com.caroline.hruser.controller;


import com.caroline.hruser.entity.User;
import com.caroline.hruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        return ResponseEntity.ok(repository.findById(id).get());
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> getByEmail(@RequestParam String email){
        return ResponseEntity.ok(repository.findByEmail(email));
    }

}
