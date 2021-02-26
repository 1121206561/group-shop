package cn.youxu.shop.controller;

import cn.youxu.shop.common.CommonResponse;
import cn.youxu.shop.entity.CouponDTO;
import cn.youxu.shop.service.ArticleService;
import cn.youxu.shop.service.CouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@Api(description = "优惠卷接口实现")
@RequestMapping("/coupon")
@CrossOrigin
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping("/getCouponList")
    @ApiOperation("优惠卷查询")
    public CommonResponse getCouponList(@RequestParam(required = false) BigDecimal couponThreshold,
                                        @RequestParam(required = false) BigDecimal couponMoney,
                                        @RequestParam(required = false, defaultValue = "1") Integer page,
                                        @RequestParam(required = false, defaultValue = "100") Integer size) {
        try {
            return CommonResponse.ok().data("content", couponService.getCouponList(couponThreshold, couponMoney, page, size));
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @PostMapping("/updateOrAddCouponById")
    @ApiOperation("优惠卷新增")
    public CommonResponse updateOrAddCouponById(@RequestBody(required = false) CouponDTO couponDTO) {
        try {
            couponService.updateOrAddCouponById(couponDTO);
            return CommonResponse.ok();
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @PostMapping("/giftCoupon")
    @ApiOperation("赠送优惠卷")
    public CommonResponse giftCoupon(@RequestBody(required = false) List<CouponDTO> couponDTOS,
                                     @RequestParam Integer userNumber) {
        try {
            couponService.giftCoupon(couponDTOS,userNumber);
            return CommonResponse.ok();
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @PostMapping("/delayTime")
    @ApiOperation("批量延时")
    public CommonResponse delayTime(@RequestBody(required = false) List<CouponDTO> couponDTOS,
                                     @RequestParam String delayTime) {
        try {
            couponService.delayTime(couponDTOS,delayTime);
            return CommonResponse.ok();
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }
}
