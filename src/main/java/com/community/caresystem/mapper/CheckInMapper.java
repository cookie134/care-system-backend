package com.community.caresystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.community.caresystem.entity.CheckIn;
import org.apache.ibatis.annotations.Mapper;

/**
 * 签到记录 Mapper 接口
 */
@Mapper // 【关键】确保有这个注解
public interface CheckInMapper extends BaseMapper<CheckIn> {
    // 继承后自动获得 CRUD 能力
}