package cn.youxu.wepy.shop.controller;

import cn.youxu.wepy.shop.common.CommonResponse;
import cn.youxu.wepy.shop.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/v1")
@CrossOrigin
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/swiperdata")
    public CommonResponse getSwiperdata(){
        try {
            return CommonResponse.ok().data("data",homeService.getSwiperdata());
        }catch (Exception e){
         return CommonResponse.error();
        }
    }

    @GetMapping("/catitems")
    public CommonResponse getCatitems(){
        try {
            return CommonResponse.ok().data("data",homeService.getCatitems());
        }catch (Exception e){
            return CommonResponse.error();
        }
    }

    @GetMapping("/floordata")
    public CommonResponse getFloordata(){
        try {
            return CommonResponse.ok().data("data",homeService.getFloordata());
        }catch (Exception e){
            return CommonResponse.error();
        }
    }

}
