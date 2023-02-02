package com.myuser.management.controller;

import com.myuser.management.Service.UserService;
import com.myuser.management.dto.UserDto;
import com.myuser.management.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/View/user/{username}")
    public UserResponse viewUserDetails(@PathVariable String username, Principal principal)
    {
      return userService.viewUserDetails(username,principal);
    }

    @PostMapping("/create/user")
    public UserResponse create(@RequestBody UserDto user)

    {
        return userService.create(user);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/update/user/{username}")
    public UserResponse updateUserDetails(@RequestBody UserDto userDto, @PathVariable String username, Principal principal)
    {
        return userService.updateUserDetails(userDto,username,principal);

    }

}
