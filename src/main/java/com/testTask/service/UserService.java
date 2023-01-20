package com.testTask.service;

import com.testTask.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getUsersList();


}
