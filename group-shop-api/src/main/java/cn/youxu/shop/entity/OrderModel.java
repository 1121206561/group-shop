package cn.youxu.shop.entity;

import cn.youxu.shop.annotation.Excel;
import lombok.Data;

@Data
public class OrderModel {
    @Excel(value = 0, cls = String.class)
    private String orderNo;
    @Excel(value = 1, cls = String.class)
    private String logisticsOrderNo;
}
