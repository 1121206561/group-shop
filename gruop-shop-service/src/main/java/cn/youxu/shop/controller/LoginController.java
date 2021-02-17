package cn.youxu.shop.controller;

import cn.youxu.shop.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/login")
@Api(description = "登陆接口实现")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/backstage")
    @ApiOperation("后台登陆")
    public void login(){
        loginService.getUser();
    }
}
