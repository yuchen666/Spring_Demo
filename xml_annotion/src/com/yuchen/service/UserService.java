package com.yuchen.service;

import com.yuchen.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    public User getUserById(int id);
}
