package com.kirago.chapter24.service;

import com.kirago.chapter24.entity.Role;
import com.kirago.chapter24.entity.User;
import com.kirago.chapter24.mapper.RoleMapper;
import com.kirago.chapter24.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userMapper.getUserByUsername(username);
        if(user != null){
            List<Role> roles = roleMapper.getRoleByUserId(user.getId());
            user.setAuthorities(roles);
        }
        return user;
    }
}
