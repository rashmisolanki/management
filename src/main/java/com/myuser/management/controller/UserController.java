package com.myuser.management.controller;

import com.myuser.management.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @GetMapping("/test/{name}")
    public String name(@PathVariable String name)
    {
        return "name";
    }

    @PostMapping("/user/create")
    public User create(@RequestBody User user)
    {
        return user;
    }
}
