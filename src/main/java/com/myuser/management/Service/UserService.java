package com.myuser.management.Service;

import com.myuser.management.dto.UserDto;
import com.myuser.management.dto.UserResponse;

import java.security.Principal;

public interface UserService {
    public UserResponse create(UserDto userdto);

    public UserResponse viewUserDetails(String username, Principal principal);

    public UserResponse updateUserDetails(UserDto userDto, String username, Principal principal);

}
