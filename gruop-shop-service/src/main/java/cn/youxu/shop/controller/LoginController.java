package cn.youxu.shop.controller;

import cn.youxu.shop.annotation.FilterFrom;
import cn.youxu.shop.common.CommonResponse;
import cn.youxu.shop.entity.StaffDTO;
import cn.youxu.shop.entity.UserVO;
import cn.youxu.shop.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@Api(description = "登陆接口实现")
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/backstage")
    @ApiOperation("后台登陆校验-生成token")
    @FilterFrom()
    public CommonResponse login(@RequestBody UserVO userVO) {
        try {
            String token = loginService.creatToken(userVO);
            return CommonResponse.ok().data("token", token);
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @GetMapping("/info")
    @ApiOperation("后台登陆-获取用户名密码")
    @FilterFrom()
    public CommonResponse info(@RequestParam String token, HttpServletResponse response) {
        StaffDTO user = loginService.getUser(token);
        if (user == null) {
            return CommonResponse.error();
        }
        return CommonResponse.ok()
                .data("roles", user.getUserRole())
                .data("jobNumber", user.getJobNumber())
                .data("name", user.getName())
                .data("avatar", user.getAvatar());
    }

    @PostMapping("/logout")
    @ApiOperation("后台登陆-登出")
    public CommonResponse logout() {
        return CommonResponse.ok();
    }
}
