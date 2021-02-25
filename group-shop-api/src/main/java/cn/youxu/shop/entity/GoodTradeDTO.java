package cn.youxu.shop.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodTradeDTO {
    private Integer id;
    private String tradeName;
    private String tradePicture;
    private Integer tradeSortId;
    private String tradeSortName;
    private String tradeJobNumber;
    private String tradeJobNumberName;
    private Integer tradeJobNumberType;
    private String tradeContent;
    private Integer isGrounding;
    private Integer isExplosive;
    private Integer sortNumber;
    private Integer isDeleted;
    private BigDecimal tradeProductPrice;
    private BigDecimal tradeMarketPrice;
    private Integer tradeCommission;
    private Integer tradeSurplus;
    private Integer tradeSalesVolume;
}
