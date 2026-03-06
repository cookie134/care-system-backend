package com.community.caresystem.controller;

import com.community.care_system.entity.CareRecord;
import com.community.caresystem.mapper.CareRecordMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/care_records") // 小程序访问路径
public class CareRecordController {

    @Autowired
    private CareRecordMapper careRecordMapper;

    // 用来处理 JSON 转换的工具
    private final ObjectMapper objectMapper = new ObjectMapper();

    // 1. 获取服务记录列表 (GET)
    @GetMapping
    public Map<String, Object> getRecords() {
        List<CareRecord> list = careRecordMapper.selectAll();

        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("data", list);
        return result;
    }

    // 2. 提交服务记录 (POST)
    // 前端发来的是一个复杂的 JSON，我们用 Map<String, Object> 来统用接收，然后自己拆解
    @PostMapping
    public Map<String, Object> addRecord(@RequestBody Map<String, Object> requestBody) {
        try {
            // --- 1. 从前端请求中提取数据 ---
            // 提取 elderInfo (老人信息)
            Map<String, Object> elderInfo = (Map<String, Object>) requestBody.get("elderInfo");
            // 提取 serviceInfo (服务信息)
            Map<String, Object> serviceInfo = (Map<String, Object>) requestBody.get("serviceInfo");
            // 提取 locationInfo (位置信息)
            Map<String, Object> locationInfo = (Map<String, Object>) requestBody.get("locationInfo");

            // --- 2. 构建 CareRecord 实体对象 ---
            CareRecord record = new CareRecord();

            // 填入老人信息
            if (elderInfo != null) {
                // 注意：这里假设前端传来的 id 是数字类型。如果是字符串，可能需要 Long.parseLong()
                Object idObj = elderInfo.get("id");
                if(idObj instanceof Integer) record.setElderId(((Integer)idObj).longValue());
                else if(idObj instanceof String) record.setElderId(Long.parseLong((String)idObj));

                record.setElderName((String) elderInfo.get("name"));
            }

            // 填入服务信息
            if (serviceInfo != null) {
                record.setServiceType((String) serviceInfo.get("serviceType"));
                record.setStaffName((String) serviceInfo.get("staffName"));
                record.setServiceContent((String) serviceInfo.get("content"));

                // 处理图片：把 List 数组转成 JSON 字符串存入数据库
                Object photos = serviceInfo.get("media"); // 前端叫 media
                if (photos != null) {
                    String photosJson = objectMapper.writeValueAsString(photos);
                    record.setPhotos(photosJson);
                }
            }

            // 填入位置
            if (locationInfo != null) {
                record.setLocation((String) locationInfo.get("address"));
            }

            record.setServiceTime(new Date()); // 设置当前时间
            record.setStatus("已完成");

            // --- 3. 保存到数据库 ---
            careRecordMapper.insert(record);

            Map<String, Object> result = new HashMap<>();
            result.put("code", 0);
            result.put("message", "归档成功");
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> errorResult = new HashMap<>();
            errorResult.put("code", -1);
            errorResult.put("message", "服务器错误: " + e.getMessage());
            return errorResult;
        }
    }
}