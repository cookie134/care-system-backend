package com.community.care_system.entity;

import lombok.Data;
import java.util.Date;

/**
 * 服务记录实体类
 */
@Data
public class CareRecord {
    private Long id;
    private Long elderId;           // 关联的老人ID
    private String elderName;       // 老人姓名
    private String serviceType;     // 服务类型
    private String staffName;       // 服务人员
    private String serviceContent;  // 服务内容
    private String photos;          // 照片 (JSON字符串)
    private String location;        // 位置
    private Date serviceTime;       // 服务发生时间
    private String status;          // 状态
    private Date createTime;        // 提交时间
}