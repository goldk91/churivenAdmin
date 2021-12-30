package com.churiven.admin.gps.controller;

import com.churiven.admin.gps.service.GpsService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class GpsController {

    @Autowired
    private GpsService gpsService;

    @ResponseBody
    @RequestMapping("/gps")
    public Object gps(HttpServletRequest req){

        List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
        String stf_seq = req.getParameter("stf_seq");
        String cmp_seq = req.getParameter("cmp_seq");

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        lists = gpsService.selectGps(stf_seq, cmp_seq);

        for(int i = 0; i < lists.size(); i++){
            JSONObject jsonLatLng = new JSONObject();
            jsonLatLng.put("lat", lists.get(i).get("GPS_LAT"));
            jsonLatLng.put("lng", lists.get(i).get("GPS_LNG"));
            jsonArray.add(jsonLatLng);
        }
        jsonObject.put("json", jsonArray);
        System.out.println(jsonObject);

        return jsonObject;
    }
}
