package com.myuser.management.dto;

import lombok.Data;

import java.util.Set;

@Data
public class RoleDto {
    Set<String> role;
    String username;

}
