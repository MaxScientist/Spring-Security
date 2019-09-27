package org.doit.service.impl;

import org.doit.model.User;
import org.doit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = repository.findByEmail(username.toLowerCase());
      if (user == null){
          throw new UsernameNotFoundException("User " + username + " not found");
      }
        return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),user.isEnabled(),true,
                true,true,user.getRoles());
    }
}
