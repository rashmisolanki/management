package com.myuser.management.Service;

import com.myuser.management.dto.RoleDto;
import com.myuser.management.dto.UserResponse;

import java.util.List;

public interface RoleService {
    public void createRole(RoleDto requestRole  );

    public void deleteUserByAdmin(String username);

    public UserResponse userDetailsByAdmin(String username);

    public List<UserResponse> viewAllUserDetails();
}
