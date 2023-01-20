package com.testTask.service.impl;

import com.testTask.model.User;
import com.testTask.repository.UserRepository;
import com.testTask.service.UserService;
import com.testTask.utils.TypeRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUsersList() {
        return userRepository.findAll();
    }


}
