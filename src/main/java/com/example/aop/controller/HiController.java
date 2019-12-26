package com.example.aop.controller;

import com.example.aop.aopdemo.TargetClass;
import com.example.aop.dto.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HiController {

    @Autowired
    TargetClass targetClass;

    @RequestMapping("/hello")
    public String Hello() {
        return "hello word";
    }

    @ApiOperation("测试自定义验证注解")
    @RequestMapping("/valid")
    public User Valid(@Valid User user) {
        return user;
    }

    @ApiOperation("测试aop")
    @RequestMapping("/aop")
    public String Aop() {
        String result = targetClass.joint("spring", "aop");

        return result;
    }


}
