package com.community.care_system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

@Data
@TableName("service_records") // 对应数据库表名
public class CareRecord {
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("elder_id")
    private Long elderId;

    @TableField("elder_name")
    private String elderName;

    @TableField("reporter_name")
    private String reporterName;

    @TableField("staff_name")
    private String staffName;

    @TableField("service_type")
    private String serviceType;

    @TableField("service_content")
    private String serviceContent;

    private String photos; // 数据库已改为 TEXT 类型
    private String location;
    private String status;

    @TableField("create_time")
    private Date createTime;

    @TableField("accept_time")
    private Date acceptTime;

    @TableField("finish_time")
    private Date finishTime;
}