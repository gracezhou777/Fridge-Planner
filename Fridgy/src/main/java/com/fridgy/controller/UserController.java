package com.fridgy.controller;

import com.fridgy.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.fridgy.model.entity.User;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "User接口", description = "用户注册与登录")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @Operation(summary = "用户注册")
    public void register(@RequestBody User user) {
        userService.register(user);
    }

    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public String login(@RequestBody Map<String, String> loginForm) {
        return userService.login(loginForm.get("username"), loginForm.get("password"));
    }
}

