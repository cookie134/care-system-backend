package com.community.caresystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.community.caresystem.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}