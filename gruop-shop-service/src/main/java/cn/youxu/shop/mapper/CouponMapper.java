package cn.youxu.shop.mapper;

import cn.youxu.shop.entity.CouponDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface CouponMapper {
    List<CouponDTO> getCouponList(@Param("couponThreshold") BigDecimal couponThreshold, @Param("couponMoney") BigDecimal couponMoney);

    void updateOrAddCouponById(@Param("couponDTO") CouponDTO couponDTO);

    void delayTime(@Param("delayTime") String delayTime, @Param("list") List<CouponDTO> couponDTOS);
}
