package com.myuser.management.dto;

import lombok.Data;


import java.util.Set;

@Data
public class UserResponse {
    String username;
    String password;
    String emailid;
    Set<String> role;


}
