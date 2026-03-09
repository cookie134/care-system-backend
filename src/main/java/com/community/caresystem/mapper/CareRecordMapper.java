package com.community.caresystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.community.care_system.entity.CareRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CareRecordMapper extends BaseMapper<CareRecord> {
    // 继承 BaseMapper 后，selectList 等方法会自动生效
}