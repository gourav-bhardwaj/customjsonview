package com.govtech.customjsonview.service;

import com.govtech.customjsonview.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public void saveUser(User userObj) {
        userObj.setUserId(users.size() + 1);
        users.add(userObj);
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(Integer userId) {
        return users.stream().filter(obj -> obj.getUserId() == userId)
                .findFirst().orElseThrow(() -> new RuntimeException("Invalid User"));
    }

}
