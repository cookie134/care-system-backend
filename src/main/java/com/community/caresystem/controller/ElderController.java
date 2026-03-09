package com.community.caresystem.controller;

import com.community.caresystem.entity.Elder;
import com.community.caresystem.mapper.ElderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 老人档案管理控制器
 * 对应小程序路径: /api/elders
 */
@RestController
@RequestMapping("/api/elders")
public class ElderController {

    @Autowired
    private ElderMapper elderMapper;

    /**
     * 1. 获取老人列表 (GET)
     * 用于小程序“开始服务登记”页面展示老人选项
     */
    @GetMapping
    public Map<String, Object> getElders() {
        try {
            // 使用 MyBatis-Plus 的 selectList(null) 查询表中所有记录
            List<Elder> list = elderMapper.selectList(null);

            Map<String, Object> result = new HashMap<>();
            result.put("code", 0);
            result.put("data", list);
            return result;
        } catch (Exception e) {
            // 如果数据库查询失败，捕获异常并返回具体原因
            e.printStackTrace();
            Map<String, Object> error = new HashMap<>();
            error.put("code", -1);
            error.put("message", "获取老人列表失败: " + e.toString());
            return error;
        }
    }

    /**
     * 2. 添加老人档案 (POST)
     * 用于后台或小程序添加新的老人信息
     */
    @PostMapping
    public Map<String, Object> addElder(@RequestBody Elder elder) {
        try {
            // 执行插入操作
            elderMapper.insert(elder);

            Map<String, Object> result = new HashMap<>();
            result.put("code", 0);
            result.put("message", "添加成功");
            result.put("id", elder.getId()); // 返回新生成的自增ID
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> error = new HashMap<>();
            error.put("code", -1);
            error.put("message", "添加老人失败: " + e.getMessage());
            return error;
        }
    }
}