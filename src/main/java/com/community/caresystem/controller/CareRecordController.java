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
     * 增加了详细的报错捕获，用于排查 500 错误
     */
    @GetMapping
    public Map<String, Object> getRecords() {
        try {
            // 查询所有记录
            List<CareRecord> list = careRecordMapper.selectList(null);

            Map<String, Object> result = new HashMap<>();
            result.put("code", 0);
            result.put("data", list);
            return result;
        } catch (Exception e) {
            // 如果报错了，会在控制台打印具体原因，并返回给小程序
            e.printStackTrace();
            Map<String, Object> error = new HashMap<>();
            error.put("code", -1);
            error.put("message", "后端报错详情: " + e.toString());
            return error;
        }
    }

    /**
     * 2. 提交服务申请 (POST) - 家属端发起需求
     */
    @PostMapping
    public Map<String, Object> addRecord(@RequestBody CareRecord record) {
        try {
            // 设置初始状态和创建时间
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
            error.put("message", "提交失败: " + e.getMessage());
            return error;
        }
    }
    /**
     * 3. 员工接单接口 (POST)
     * 接收参数: { "id": 1, "staffName": "张三" }
     */
    @PostMapping("/accept")
    public Map<String, Object> acceptRecord(@RequestBody Map<String, Object> params) {
        try {
            // 获取前端传来的 ID
            Long id = Long.valueOf(params.get("id").toString());
            String staffName = (String) params.get("staffName");

            // 1. 查询该条记录
            CareRecord record = careRecordMapper.selectById(id);
            if (record == null) {
                throw new RuntimeException("该记录不存在");
            }

            // 2. 检查状态（防止被别人抢先接单）
            if (!"待接单".equals(record.getStatus())) {
                throw new RuntimeException("该任务已被接单或已完成");
            }

            // 3. 修改状态并保存
            record.setStatus("已接单");
            record.setStaffName(staffName);
            record.setAcceptTime(new Date()); // 记录接单时间

            careRecordMapper.updateById(record);

            Map<String, Object> result = new HashMap<>();
            result.put("code", 0);
            result.put("message", "接单成功");
            return result;
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("code", -1);
            error.put("message", e.getMessage());
            return error;
        }
    }


}