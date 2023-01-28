package com.myuser.management.dto;

import lombok.Data;

import java.util.Set;

@Data
public class RoleResponse {
    Long id;
    Set<String> role;
    Set<String> username;
}
