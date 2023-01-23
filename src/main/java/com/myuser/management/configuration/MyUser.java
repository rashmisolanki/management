package com.myuser.management.configuration;

import com.myuser.management.entity.RoleEntity;
import com.myuser.management.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class MyUser implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> simpleGrantedAuthorityList=new ArrayList<>();
        SimpleGrantedAuthority simpleGrantedAuthority = null;
        //convert to java 8
        for(RoleEntity role : userEntity.getRoleEntitySet())
        {
            String singleRole=role.getRole();
            simpleGrantedAuthority=new SimpleGrantedAuthority(singleRole);
            simpleGrantedAuthorityList.add(simpleGrantedAuthority);
        }
        return simpleGrantedAuthorityList;
    }
    private UserEntity userEntity;
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
