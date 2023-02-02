package com.myuser.management.controller;

import com.myuser.management.Service.RoleService;
import com.myuser.management.dto.RoleDto;
import com.myuser.management.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private RoleService roleService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create/role")
    public void createRole(@RequestBody RoleDto role)
    {
        roleService.createRole(role);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/user/{username}")
    public void deleteUserBYAdmin(@PathVariable String username)
    {
        roleService.deleteUserByAdmin(username);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/view/user/details/{username}")
    public UserResponse userDetailsByAdmin(@PathVariable String username)
    {
        return roleService.userDetailsByAdmin(username);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/view/all/user")
    public List<UserResponse> viewAllUserDetails()
    {
          return roleService.viewAllUserDetails();
    }

}
