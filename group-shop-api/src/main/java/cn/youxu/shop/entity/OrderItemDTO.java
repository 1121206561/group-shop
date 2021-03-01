package cn.youxu.shop.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO {
    private Integer id;
    private String orderItemNo;
    private String orderNo;
    private Integer orderUser;
    private String orderUserName;
    private Integer orderCount;
    private BigDecimal orderPayAmount;
    private BigDecimal orderSumAmount;
    private Integer orderCouponId;
    private String orderCouponName;
    private String payTime;
    private Integer orderItemType;
    private String orderItemName;
    private String placeTime;
    private Integer shippWay;
    private String shippWayName;
    private Integer payWay;
    private String payWayName;
    private Integer isDeleted;
}
