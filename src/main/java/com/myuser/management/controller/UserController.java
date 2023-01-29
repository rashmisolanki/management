package com.myuser.management.controller;

import com.myuser.management.Service.UserService;
import com.myuser.management.Service.UserServiceImplementation;
import com.myuser.management.dto.UserDto;
import com.myuser.management.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/test/{username}")
    public String name(@PathVariable String username)
    {
        return "successfully called with pathvaribale" + username;
    }

    @PostMapping("/create/user")
    public UserResponse create(@RequestBody UserDto user)

    {
        return userService.create(user);
    }

}
