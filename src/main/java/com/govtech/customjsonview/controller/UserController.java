package com.govtech.customjsonview.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.govtech.customjsonview.dto.User;
import com.govtech.customjsonview.service.UserService;
import com.govtech.customjsonview.view.Views;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        log.info("Save employee");
        System.out.println(user.toString());
        service.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User saved successfully");
    }

    @GetMapping
    @JsonView(Views.UserView.class)
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(service.getUsers());
    }

    @GetMapping("/{userId}")
    @JsonView(Views.UserView.class)
    public ResponseEntity<User> getUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(service.getUser(userId));
    }

    @GetMapping("/contact/{userId}")
    @JsonView(Views.UserContactInfo.class)
    public ResponseEntity<User> getUserContact(@PathVariable Integer userId) {
        return ResponseEntity.ok(service.getUser(userId));
    }

    @GetMapping("/address/{userId}")
    @JsonView(Views.UserAddressView.class)
    public ResponseEntity<User> getUserAddress(@PathVariable Integer userId) {
        return ResponseEntity.ok(service.getUser(userId));
    }

    @GetMapping("/all")
    @JsonView(Views.UserInfo.class)
    public ResponseEntity<List<User>> getCompleteUsers() {
        return ResponseEntity.ok(service.getUsers());
    }

    @GetMapping("/all/{userId}")
    @JsonView(Views.UserInfo.class)
    public ResponseEntity<User> getCompleteUsers(@PathVariable Integer userId) {
        return ResponseEntity.ok(service.getUser(userId));
    }

}
