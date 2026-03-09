package com.community.caresystem.controller;

import com.community.caresystem.entity.Elder;
import com.community.caresystem.mapper.ElderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/elders")
public class ElderController {

    @Autowired
    private ElderMapper elderMapper;

    @GetMapping
    public Map<String, Object> getElders() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("data", elderMapper.selectList(null));
        return result;
    }

    @PostMapping
    public Map<String, Object> addElder(@RequestBody Elder elder) {
        elderMapper.insert(elder);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("id", elder.getId()); // 这里就不会报错了
        return result;
    }
}