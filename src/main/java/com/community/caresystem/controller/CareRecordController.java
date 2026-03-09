package com.community.caresystem.controller;

import com.community.caresystem.entity.CareRecord;
import com.community.caresystem.mapper.CareRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/care_records")
public class CareRecordController {

    @Autowired
    private CareRecordMapper careRecordMapper;

    /**
     * 1. 获取所有服务记录 (GET)
     * 用于家属查看进度或员工查看任务池
     */
    @GetMapping
    public Map<String, Object> getRecords() {
        // 查询所有记录，按创建时间倒序排列
        List<CareRecord> list = careRecordMapper.selectList(null);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("data", list);
        return result;
    }

    /**
     * 2. 提交服务申请 (POST) - 家属端发起需求
     */
    @PostMapping
    public Map<String, Object> addRecord(@RequestBody CareRecord record) {
        try {
            // 后端强制初始化状态和时间，确保安全
            record.setStatus("待接单");
            record.setCreateTime(new Date());

            // 执行插入
            careRecordMapper.insert(record);

            Map<String, Object> result = new HashMap<>();
            result.put("code", 0);
            result.put("message", "需求上报成功");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> error = new HashMap<>();
            error.put("code", -1);
            error.put("message", "服务器错误: " + e.getMessage());
            return error;
        }
    }
}