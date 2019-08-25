package com.yuchen.controller;

import com.yuchen.entity.User;
import com.yuchen.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Data
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public User getUserById(int id){
        return userService.getUserById(id);
    }
}
