package com.example.dailynews.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dailynews.models.User;
import com.example.dailynews.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if(!userRepository.existsByUsername(username)){
      throw new UnsupportedOperationException(username +" is not found!!");
    }

    User user = userRepository.findByUsername(username);

    return UserDetailsImpl.create(user);
  }
  
}
