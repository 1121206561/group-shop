package cn.youxu.shop.service.impl;

import cn.youxu.shop.entity.CouponDTO;
import cn.youxu.shop.mapper.CouponMapper;
import cn.youxu.shop.service.CouponService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponMapper couponMapper;

    @Override
    public PageInfo<CouponDTO> getCouponList(BigDecimal couponThreshold, BigDecimal couponMoney, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(couponMapper.getCouponList(couponThreshold, couponMoney));
    }

    @Override
    public void updateOrAddCouponById(CouponDTO couponDTO) {
        couponMapper.updateOrAddCouponById(couponDTO);
    }

    @Override
    public void giftCoupon(List<CouponDTO> couponDTOS, Integer userNumber) {
        //todo
    }

    @Override
    public void delayTime(List<CouponDTO> couponDTOS, String delayTime) {
        couponMapper.delayTime(delayTime,couponDTOS);
    }
}
