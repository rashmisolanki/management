package com.myuser.management.Service;

import com.myuser.management.Repositary.RoleRepo;
import com.myuser.management.dto.RoleDto;
import com.myuser.management.dto.RoleResponse;
import com.myuser.management.entity.RoleEntity;
import com.myuser.management.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public RoleResponse createRole(RoleDto role)
    {
        RoleEntity roleEntity=new RoleEntity();
        roleEntity.setRole(role.getRole());

        roleRepo.save(roleEntity);

        RoleResponse roleResponse=new RoleResponse();
        roleResponse.setRole(roleEntity.getRole());
        roleResponse.setId(roleEntity.getId());
        return roleResponse;

    }
}
