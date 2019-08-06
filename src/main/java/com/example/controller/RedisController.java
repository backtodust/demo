package com.example.controller;
import com.example.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {


    @Autowired
    private RedisService redisService ;


    @RequestMapping(value = "/test")
    @ResponseBody
    public String demoTest(){
       if (redisService.set("abc","value22222"))

        return "oK";
       return "bad";
    }


    @RequestMapping(value = "/test2")
    @ResponseBody
    public String demoTest2(){
      return (String)redisService.get("abc");


    }
}
