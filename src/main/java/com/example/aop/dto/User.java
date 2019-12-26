package com.example.aop.dto;

import com.example.aop.util.MyConstraint;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class User {
    @MyConstraint(min = 1, max = 10)
    @ApiModelProperty("用户名")
    public String name;
    @ApiModelProperty("地址")
    public String address;
}
