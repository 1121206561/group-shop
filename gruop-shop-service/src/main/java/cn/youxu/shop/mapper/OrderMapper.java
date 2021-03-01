package cn.youxu.shop.mapper;

import cn.youxu.shop.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    List<OrderDTO> getOrderList(@Param("orderNo") String orderNo, @Param("type") Integer type,
                                @Param("staffNumber") String staffNumber, @Param("tradeId") Integer tradeId,
                                @Param("logisticsOrderNo") String logisticsOrderNo, @Param("beginCreationTime") String beginCreationTime,
                                @Param("endCreationTime") String endCreationTime);

    List<OrderDTO> getOrderByOrderNo(@Param("orderNo") String orderNo);

    int updateTypeByOrderNo(@Param("afterOrderType") int afterOrderType, @Param("orderType") int orderType, @Param("orderNo") String orderNo);

    void updateLogisticsOrderNo(@Param("list") List<OrderModel> orderModels);

    List<OrderDTO> selectByOrderNo(@Param("list") List<OrderModel> orderModels);

    List<OrderItemDTO> getOrderItemList(@Param("orderNo") String orderNo, @Param("orderItemNo")String orderItemNo,
                                        @Param("timeWay")Integer timeWay, @Param("orderUser")Integer orderUser,
                                        @Param("orderItemType")Integer orderItemType, @Param("beginCreationTime")String beginCreationTime,
                                        @Param("endCreationTime")String endCreationTime, @Param("shippWay")Integer shippWay,
                                        @Param("payWay")Integer payWay);

    List<OrderAssessDTO> getOrderAssessList(@Param("orderItemNo")String orderItemNo, @Param("evaluatorId")Integer evaluatorId,
                                            @Param("starRating")Integer starRating, @Param("type")Integer type,
                                            @Param("beginCreationTime")String beginCreationTime, @Param("endCreationTime")String endCreationTime);

    void updateAssessTypeById(@Param("orderAssessDTO") OrderAssessDTO orderAssessDTO);

    List<OrderDeliveryDTO> getOrderDeliveryList(@Param("orderItemNo") String orderItemNo);
}