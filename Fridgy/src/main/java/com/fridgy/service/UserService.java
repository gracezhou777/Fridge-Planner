package com.fridgy.service;

import com.fridgy.model.entity.User;

public interface UserService {
    void register(User user);
    String login(String username, String password);
    User getByUsername(String username);
}
