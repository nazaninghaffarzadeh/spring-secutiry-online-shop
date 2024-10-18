package com.nazanin.ecom.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nazanin.ecom.proj.model.User;

public interface UserRepo extends JpaRepository<User,Integer>{
 User findByUserName(String username);

    
}
