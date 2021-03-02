package cn.youxu.shop.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRecordDTO {
    private Integer orderCount;
    private BigDecimal orderAmount;
    private Integer orderUser;
    private Integer orderBackUser;
    private Integer orderCancel;
    private BigDecimal payAmount;
    private List<OrderDTO> orderDTOS;

    public OrderRecordDTO(){
        this.orderCount = 0;
        this.orderAmount = BigDecimal.ZERO;
        this.orderUser = 0;
        this.orderBackUser = 0;
        this.orderCancel = 0;
        this.payAmount = BigDecimal.ZERO;
    }
}
