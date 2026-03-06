package com.community.caresystem.mapper;

import com.community.care_system.entity.Elder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface ElderMapper {
    // 插入老人信息
    @Insert("INSERT INTO elders(name, gender, age, id_card, phone, address, care_level, emergency_contact, emergency_phone, health_notes) " +
            "VALUES(#{name}, #{gender}, #{age}, #{idCard}, #{phone}, #{address}, #{careLevel}, #{emergencyContact}, #{emergencyPhone}, #{healthNotes})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Elder elder);

    // 查询所有老人
    @Select("SELECT * FROM elders ORDER BY create_time DESC")
    List<Elder> selectAll();
}