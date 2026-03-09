package com.community.caresystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
    private String reporterName; // 对应 reporter_name
    private String staffName;    // 对应 staff_name
    private String serviceType;
    private String serviceContent;
    private String photos;
    private String location;
    private String status;
    private Date createTime;     // 对应 create_time
    private Date acceptTime;     // 对应 accept_time
    private Date finishTime;     // 对应 finish_time
}