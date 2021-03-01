package cn.youxu.shop.entity;

import lombok.Data;

@Data
public class OrderDeliveryDTO {
    private Integer id;
    private String deliveryMan;
    private String orderNo;
    private Integer commissionWay;
    private String commissionWayName;
    private String phone;
    private Integer type;
    private String typeName;
}
