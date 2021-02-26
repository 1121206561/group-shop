package cn.youxu.shop.service;

import cn.youxu.shop.entity.CouponDTO;
import com.github.pagehelper.PageInfo;

import java.math.BigDecimal;
import java.util.List;

public interface CouponService {
    PageInfo<CouponDTO> getCouponList(BigDecimal couponThreshold, BigDecimal couponMoney, Integer page, Integer size);

    void updateOrAddCouponById(CouponDTO couponDTO);

    void giftCoupon(List<CouponDTO> couponDTOS, Integer userNumber);

    void delayTime(List<CouponDTO> couponDTOS, String delayTime);
}
