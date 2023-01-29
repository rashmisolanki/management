package com.myuser.management.Service;

import com.myuser.management.dto.UserDto;
import com.myuser.management.dto.UserResponse;

public interface UserService {
    public UserResponse create(UserDto userdto);

    public UserResponse find(String username);

}
