package cn.youxu.shop.entity;

import lombok.Data;

@Data
public class OrderAssessDTO {
    private Integer id;
    private String orderItemNo;
    private Integer evaluatorId;
    private String  evaluatorName;
    private String result;
    private String content;
    private Integer starRating;
    private Integer type;
    private String typeName;
    private String evaluatorTime;
}
