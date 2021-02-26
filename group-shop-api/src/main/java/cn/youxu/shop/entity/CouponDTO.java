package cn.youxu.shop.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CouponDTO {
    private Integer id;
    private String couponName;
    private String couponUserDes;
    private String couponPicture;
    private Integer couponUser;
    private String couponTime;
    private Integer couponDraw;
    private BigDecimal couponThreshold;
    private BigDecimal couponMoney;
    private Integer isDeleted;
}
