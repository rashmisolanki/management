package com.myuser.management.Service;

import com.myuser.management.Repositary.RoleRepo;
import com.myuser.management.Repositary.UserRepo;
import com.myuser.management.dto.RoleDto;
import com.myuser.management.dto.UserResponse;
import com.myuser.management.entity.RoleEntity;
import com.myuser.management.entity.UserEntity;
import com.myuser.management.exception.ResourceNotFound;
import com.myuser.management.exception.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImplementation implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRepo userRepo;
    public void createRole(RoleDto requestRole  ) {
        Optional<UserEntity> userEntity = userRepo.findById(requestRole.getUsername());
        userEntity.orElseThrow(() -> new ResourceNotFound("username is not found"));
       //exracting user roles from db.
        Set<String> dbRoles =userEntity.get().getRoleEntitySet().stream().map(role->role.getRole()).collect(Collectors.toSet());
        //comparing input roles with dbroles to extract unique.
        Set<String> requestRoles= requestRole.getRole().stream().filter(role->!dbRoles.contains(role)).collect(Collectors.toSet());
//convert to java 8
//        for(String inputRole:requestRoles)
//        {
//            if(!dbRoles.contains(inputRole))
//            {
//                roleToBeAdded.add(inputRole);
//            }
//        }
        //save roles to DB
     Set<RoleEntity>  roleEntitySet =requestRoles.stream().map(role-> saveRolesToDb(role,userEntity.get())).collect(Collectors.toSet());
    }
    private RoleEntity saveRolesToDb(String role,UserEntity userEntity)
    {
        RoleEntity roleEntity= new RoleEntity();
        roleEntity.setRole(role);
        roleEntity.setUser(userEntity);
        return roleRepo.save(roleEntity);
    }

    public void deleteUserByAdmin(String username){
        Optional<UserEntity> userEntity=userRepo.findById(username);
        //use orElse to throw exception
        if(!userEntity.isPresent())
        {
            throw new UserNotFound("user is not present");
        }
      userRepo.deleteById(username);
    }

    public UserResponse userDetailsByAdmin(String username)
    {
        Optional<UserEntity> userEntity=userRepo.findById(username);
        //use map and orElseTrow
        if(!userEntity.isPresent())
        {
            throw new UserNotFound("username is not present in database");
        }
        UserEntity userDeatils= userEntity.get();
        UserResponse userResponse=new UserResponse();
        userResponse.setUsername(userDeatils.getUsername());
        userResponse.setEmailid(userDeatils.getMailid());
        Set<String> roleSet=userDeatils.getRoleEntitySet().stream().map(RoleEntity::getRole).collect(Collectors.toSet());
        userResponse.setRole(roleSet);
        return userResponse;
    }

    public List<UserResponse> viewAllUserDetails()
    {
       List<UserEntity> userEntity= userRepo.findAll();
// do it using a function in map.
       List<UserResponse> userResponseList=userEntity.stream().map(user->
       {
           UserResponse userResponse=new UserResponse();
         userResponse.setUsername(user.getUsername());
         userResponse.setEmailid(user.getMailid());
         userResponse.setRole(roleSet(user));
         return  userResponse;
       }).collect(Collectors.toList());
       return userResponseList;
    }

    private Set<String> roleSet(UserEntity role)
    {
      Set<String> returnRoleSet =role.getRoleEntitySet().stream().map(RoleEntity::getRole).collect(Collectors.toSet());
      return returnRoleSet;
    }
}
