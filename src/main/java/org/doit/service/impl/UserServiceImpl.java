package org.doit.service.impl;

import org.doit.model.Address;
import org.doit.model.User;
import org.doit.repository.UserRepository;
import org.doit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getOne(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public void add(User user) {           //<--setting address
//        user.setAddress(address);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
