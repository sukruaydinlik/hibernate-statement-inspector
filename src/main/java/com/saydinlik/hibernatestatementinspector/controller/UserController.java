package com.saydinlik.hibernatestatementinspector.controller;

import com.saydinlik.hibernatestatementinspector.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.saydinlik.hibernatestatementinspector.model.User;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping()
    public Long addUser(@RequestBody User user) {
        return userRepository.save(user).getId();
    }
}
