package com.community.caresystem.mapper;

import com.community.care_system.entity.CareRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface CareRecordMapper {
    // 插入服务记录
    @Insert("INSERT INTO service_records(elder_id, elder_name, service_type, staff_name, service_content, photos, location, service_time, status) " +
            "VALUES(#{elderId}, #{elderName}, #{serviceType}, #{staffName}, #{serviceContent}, #{photos}, #{location}, #{serviceTime}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(CareRecord record);

    // 查询所有记录
    @Select("SELECT * FROM service_records ORDER BY service_time DESC")
    List<CareRecord> selectAll();
}