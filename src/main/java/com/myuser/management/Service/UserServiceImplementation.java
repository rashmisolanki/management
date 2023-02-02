package com.myuser.management.Service;

import com.myuser.management.Repositary.UserRepo;
import com.myuser.management.dto.UserDto;
import com.myuser.management.dto.UserResponse;
import com.myuser.management.entity.RoleEntity;
import com.myuser.management.entity.UserEntity;
import com.myuser.management.exception.UserAlreadyPresent;
import com.myuser.management.exception.UserNotFound;
import com.myuser.management.exception.UserNotMatching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

        userRepo.save(userEntity);
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(userEntity.getUsername());
        userResponse.setPassword(userEntity.getPassword());
        userResponse.setEmailid(userEntity.getMailid());
        //Set<String> dbRoleList=userEntity.getRoleEntitySet().stream().map(RoleEntity::getRole).collect(Collectors.toSet());
        //userResponse.setRole(dbRoleList);
        return userResponse;

    }


    public UserResponse viewUserDetails(String username, Principal principal)
    {
        if(!(principal.getName().equalsIgnoreCase(username)))
        {
            throw new UserNotMatching("username and input details are not matching");
        }
        Optional<UserEntity> userEntity=userRepo.findById(username);
        //option use map or ElseThrow, refer user project.
        if(!userEntity.isPresent())
        {
            throw new UserNotFound("User is not present in our database");
        }
        UserEntity userDetails=userEntity.get();
        UserResponse userResponse=new UserResponse();
        userResponse.setUsername(userDetails.getUsername());
        userResponse.setPassword(userDetails.getPassword());
        userResponse.setEmailid(userDetails.getMailid());
        Set<String> roleSet=userDetails.getRoleEntitySet().stream().map(RoleEntity::getRole).collect(Collectors.toSet());
        userResponse.setRole(roleSet);
        return userResponse;
    }

    public UserResponse updateUserDetails(UserDto userDto, String username,Principal principal)
    {
        if(!(principal.getName().equalsIgnoreCase(userDto.getUsername())&&
        principal.getName().equalsIgnoreCase(username)))
        {
         throw new UserNotMatching("username and input details are not matching.");
        }
       Optional<UserEntity> userEntity= userRepo.findById(principal.getName());
        //user optional orElse to throw exception
       if(!userEntity.isPresent())
       {
           throw new UserNotFound("User is not present in our Database.");
       }

           UserEntity fetchUserEntity = userEntity.get();
         //  fetchUserEntity.setUsername(userDto.getUsername());
        //check for null in mail id and password.
           fetchUserEntity.setPassword(userDto.getPassword());
           fetchUserEntity.setMailid(userDto.getEmailid());

           UserEntity updatedUserDetails = userRepo.save(fetchUserEntity);
          UserResponse userResponse = new UserResponse();
           userResponse.setUsername(updatedUserDetails.getUsername());
           userResponse.setPassword(updatedUserDetails.getPassword());
           userResponse.setEmailid(updatedUserDetails.getMailid());

           return userResponse;
    }

}
