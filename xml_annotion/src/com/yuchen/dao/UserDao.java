package com.yuchen.dao;

import com.yuchen.entity.User;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Data
@Repository
public class UserDao {
    private static Map<Integer, User> users;

    static{
        users = new HashMap<Integer, User>();
        users.put(1,new User(1,"于晨"));
        users.put(1,new User(2,"张三"));
        users.put(1,new User(3,"李四"));
    }

    public User getUserById(int id){
        return users.get(id);
    }
}
