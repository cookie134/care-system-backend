package com.community.caresystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

@Data
@TableName("check_ins")
public class CheckIn {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long elderId;
    private java.sql.Date checkInDate;
    private Date createTime;
}