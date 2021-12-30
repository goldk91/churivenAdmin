package com.churiven.admin;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Home {

    @RequestMapping("/hi")
    public String hi(){
        System.out.println("hihi");
        return "hi";
    }

    @RequestMapping("/map")
    public String map(){
        System.out.println("map");
        return "map";
    }

}
