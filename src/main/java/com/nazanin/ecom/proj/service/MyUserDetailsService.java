package com.nazanin.ecom.proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.nazanin.ecom.proj.model.UserPrincipal;

import com.nazanin.ecom.proj.model.User;
import com.nazanin.ecom.proj.repository.UserRepo;

public class MyUserDetailsService implements UserDetailsService{

    @Autowired 
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user=userRepo.findByUserName(username);
       if(user== null){
        System.out.println("user not found");
        throw new UsernameNotFoundException(" user not found");
       }
    
        return new UserPrincipal(user);
    }
    
}
