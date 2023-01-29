package com.myuser.management.Service;

import com.myuser.management.Repositary.UserRepo;
import com.myuser.management.dto.UserDto;
import com.myuser.management.dto.UserResponse;
import com.myuser.management.entity.UserEntity;
import com.myuser.management.exception.UserAlreadyPresent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepo userRepo;
    public UserResponse create(UserDto userdto)
    {
        UserEntity userEntity=new UserEntity();

        userEntity.setUsername(userdto.getUsername());
        userEntity.setPassword(userdto.getPassword());
        userEntity.setMailid(userdto.getEmailid());
       // Set<RoleEntity> roleEntityList=new HashSet<>();
//        Set<String> roleList=userdto.getRole();
//        for (String str:roleList){
//            RoleEntity roleEntity=new RoleEntity();
//            roleEntity.setRole(str);
//            roleEntity.setUserEntity(userEntity);
//            roleEntityList.add(roleEntity);
//        }
        //userEntity.setRoleEntitySet(roleEntityList);
        if(userRepo.existsById(userEntity.getUsername()))
        {
            throw new UserAlreadyPresent("user is already registered");
        }
        else {
            userRepo.save(userEntity);
            UserResponse userResponse = new UserResponse();
            userResponse.setUsername(userEntity.getUsername());
            userResponse.setPassword(userEntity.getPassword());
            userResponse.setEmailid(userEntity.getMailid());
            //Set<String> dbRoleList=userEntity.getRoleEntitySet().stream().map(RoleEntity::getRole).collect(Collectors.toSet());
            //userResponse.setRole(dbRoleList);
            return userResponse;
        }
    }


    public UserResponse find(String username)
    {
        UserEntity userEntity=userRepo.findById(username).get();
        UserResponse userResponse=new UserResponse();
        userResponse.setUsername(userEntity.getUsername());
        userResponse.setPassword(userEntity.getPassword());
        userResponse.setEmailid(userEntity.getMailid());
        return userResponse;
    }
}
