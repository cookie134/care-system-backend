package com.community.caresystem.controller;

import com.community.care_system.entity.Elder;
import com.community.caresystem.mapper.ElderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/elders") // 小程序访问的路径: /api/elders
public class ElderController {

    @Autowired
    private ElderMapper elderMapper;

    // 1. 获取老人列表 (GET)
    @GetMapping
    public Map<String, Object> getElders() {
        List<Elder> elders = elderMapper.selectAll();

        // 包装成小程序喜欢的格式 { code: 0, data: [...] }
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("data", elders);
        return result;
    }

    // 2. 添加老人 (POST)
    @PostMapping
    public Map<String, Object> addElder(@RequestBody Elder elder) {
        // 设置创建时间等逻辑可以由数据库默认值处理
        elderMapper.insert(elder);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("message", "添加成功");
        result.put("id", elder.getId()); // 返回新生成的ID
        return result;
    }
}