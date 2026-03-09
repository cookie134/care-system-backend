package com.community.caresystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

@Data
@TableName("service_records")
public class CareRecord {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long elderId;
    private String elderName;

    @TableField("reporter_name") // 手动指定数据库列名
    private String reporterName;

    @TableField("staff_name")
    private String staffName;

    private String serviceType;
    private String serviceContent;
    private String photos;
    private String location;
    private String status;

    @TableField("create_time")
    private Date createTime;

    @TableField("accept_time")
    private Date acceptTime;

    @TableField("finish_time")
    private Date finishTime;
}