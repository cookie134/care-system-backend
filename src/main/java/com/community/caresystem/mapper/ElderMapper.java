package com.community.caresystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.community.caresystem.entity.Elder;
import org.apache.ibatis.annotations.Mapper;

/**
 * 继承 BaseMapper 后，MyBatis-Plus 会自动实现 insert, selectList, selectById 等方法。
 * 之前的 @Insert 和 @Select 都可以删掉了。
 */
@Mapper
public interface ElderMapper extends BaseMapper<Elder> {
    // 这里不需要写任何代码
}