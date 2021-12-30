package com.churiven.admin.gps.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface GpsMapper {
    List<Map<String, Object>> selectGps(String stf_seq, String cmp_seq);
}
