package com.myuser.management.controller;

import com.myuser.management.Service.RoleService;
import com.myuser.management.Service.RoleServiceImplementation;
import com.myuser.management.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
