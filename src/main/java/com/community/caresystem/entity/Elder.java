package com.community.care_system.entity;

import lombok.Data;
import java.util.Date;

/**
 * 老人档案实体类
 */
@Data
public class Elder {
    private Long id;                // 主键ID
    private String name;            // 老人姓名
    private String gender;          // 性别
    private Integer age;            // 年龄
    private String idCard;          // 身份证号
    private String phone;           // 联系电话
    private String address;         // 家庭住址
    private String careLevel;       // 护理等级
    private String emergencyContact; // 紧急联系人
    private String emergencyPhone;   // 紧急联系人电话
    private String healthNotes;      // 健康备注
    private Date createTime;        // 创建时间
    private Date updateTime;        // 更新时间
}