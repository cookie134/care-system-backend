package com.community.caresystem.controller;

import com.community.caresystem.entity.CheckIn;
import com.community.caresystem.mapper.CheckInMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/check_ins")

public class CheckInController {

    @Autowired
    private CheckInMapper checkInMapper;

    /**
     * 1. 报平安签到
     */
    @PostMapping("/{elderId}")
    public Map<String, Object> doCheckIn(@PathVariable Long elderId) {
        CheckIn checkIn = new CheckIn();
        checkIn.setElderId(elderId);
        checkIn.setCheckInDate(new java.sql.Date(System.currentTimeMillis()));

        Map<String, Object> result = new HashMap<>();
        try {
            checkInMapper.insert(checkIn);
            result.put("code", 0);
            result.put("message", "签到成功，平安喜乐！");
        } catch (Exception e) {
            result.put("code", -1);
            result.put("message", "今日已签到过啦");
        }
        return result;
    }
}