package com.churiven.admin.gps.service;

import com.churiven.admin.gps.mapper.GpsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GpsService {
    @Autowired
    private GpsMapper gpsMapper;

    public List<Map<String, Object>> selectGps(String stf_seq, String cmp_seq) {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        System.out.print("GpsService insertGps Call");
        list = gpsMapper.selectGps(stf_seq, cmp_seq);

        return list;
    }
}
