package com.community.caresystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.community.caresystem.entity.User;
import com.community.caresystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User loginRequest) {
        Map<String, Object> result = new HashMap<>();

        // 查询数据库
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, loginRequest.getUsername())
                .eq(User::getPassword, loginRequest.getPassword()));

        if (user != null) {
            result.put("code", 0);
            result.put("message", "登录成功");
            result.put("data", user); // 返回用户信息
        } else {
            result.put("code", -1);
            result.put("message", "账号或密码错误");
        }
        return result;
    }
}