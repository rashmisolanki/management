package com.myuser.management.controller;

import com.myuser.management.Service.RoleService;
import com.myuser.management.Service.UserService;
import com.myuser.management.dto.RoleDto;
import com.myuser.management.dto.RoleResponse;
import com.myuser.management.dto.UserDto;
import com.myuser.management.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @GetMapping("/test/{username}")
    public String name(@PathVariable String username)
    {
        return "successfully called with pathvaribale" + username;
    }

    @PostMapping("/user/create")
    public UserResponse create(@RequestBody UserDto user)

    {
        return userService.create(user);
    }

    @PostMapping("/role/create")
    public RoleResponse createRole(@RequestBody RoleDto role)
    {
        return roleService.createRole(role);
    }
}
