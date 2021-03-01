package cn.youxu.shop.entity;

import cn.youxu.shop.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDTO {
    private Integer id;
    private String orderNo;
    private String staffNumber;
    private Integer tradeId;
    private String staffNumberName;
    private String  tradeName;
    private String creationTime;
    private String supplierAddress;
    private String logisticsOrderNo;
    private Integer orderUserCount;
    private BigDecimal orderMoney;
    private Integer type;
    private String typeName;
    private Integer orderCount;
    private Integer isDeleted;

}
