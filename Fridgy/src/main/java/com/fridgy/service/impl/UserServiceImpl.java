package com.fridgy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fridgy.mapper.UserMapper;
import com.fridgy.model.entity.User;
import com.fridgy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public void register(User user) {
        // 简单密码加密略（可以加 bcrypt）
        userMapper.insert(user);
    }

    @Override
    public String login(String username, String password) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }
        // 暂时返回用户id字符串（可替代为JWT）
        return "token_" + user.getId();
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
    }
}

