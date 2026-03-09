package com.community.caresystem.entity; // 统一包名

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