package com.community.caresystem.mapper; // 确保包名与你实际路径一致

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.community.caresystem.entity.CareRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 继承 BaseMapper 后，MyBatis-Plus 会自动为你生成
 * insert, delete, update, selectList 等所有常用的 CRUD 方法。
 */
@Mapper
public interface CareRecordMapper extends BaseMapper<CareRecord> {
    // 这里不需要写任何代码，selectList 等方法已经自动继承过来了
}