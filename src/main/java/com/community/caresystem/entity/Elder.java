package com.community.caresystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

/**
 * 老人档案实体类
 * 对应数据库表：elders
 */
@Data
@TableName("elders") // 【关键】指定数据库表名为 elders
public class Elder {

    @TableId(type = IdType.AUTO) // 【关键】指定主键自增
    private Long id;

    private String name;
    private String gender;
    private String age; // 如果数据库是 int，这里用 Integer 也可以

    @TableField("id_card") // 【关键】映射数据库列名 id_card
    private String idCard;

    private String phone;
    private String address;

    @TableField("care_level") // 映射 care_level
    private String careLevel;

    @TableField("emergency_contact") // 映射 emergency_contact
    private String emergencyContact;

    @TableField("emergency_phone") // 映射 emergency_phone
    private String emergencyPhone;

    @TableField("health_notes") // 映射 health_notes
    private String healthNotes;

    @TableField("create_time") // 映射 create_time
    private Date createTime;

    @TableField("update_time") // 映射 update_time
    private Date updateTime;
}