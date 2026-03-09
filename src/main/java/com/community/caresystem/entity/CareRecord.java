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

    private String reporterName; // 上报人（家属）
    private String staffName;    // 承办人（员工）

    private String serviceType;
    private String serviceContent;
    private String photos;       // 存储 JSON 字符串
    private String location;

    private String status;       // 状态：待接单/已接单/服务中/已完成

    private Date createTime;     // 上报时间
    private Date acceptTime;     // 接单时间
    private Date finishTime;     // 完成时间
}