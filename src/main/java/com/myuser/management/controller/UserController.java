package com.myuser.management.controller;

import com.myuser.management.Service.RoleService;
import com.myuser.management.Service.UserService;
import com.myuser.management.dto.RoleDto;
import com.myuser.management.dto.UserDto;
import com.myuser.management.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/role/create")
    public void createRole(@RequestBody RoleDto role)
    {
        roleService.createRole(role);
    }

}
