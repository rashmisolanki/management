package com.myuser.management.configuration;

import com.myuser.management.entity.RoleEntity;
import com.myuser.management.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class MyUser implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //returns list of user roles
        return userEntity.getRoleEntitySet().stream()
//                .map(roleEntity->authorityObjectReturn(roleEntity)
//                   ).collect(Collectors.toList());

                //using method reference
                .map(this::authorityObjectReturn).collect(Collectors.toList());
    }

    private SimpleGrantedAuthority authorityObjectReturn(RoleEntity role)
    {
        String authorityRole=role.getRole();
        SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(authorityRole);
        return simpleGrantedAuthority;
    }

    private final UserEntity userEntity;
        MyUser(UserEntity userEntity){
        this.userEntity=userEntity;
  }
    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
