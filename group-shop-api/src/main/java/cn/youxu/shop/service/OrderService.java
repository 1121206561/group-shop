package cn.youxu.shop.service;

import cn.youxu.shop.entity.*;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderService {
    PageInfo<OrderDTO> getOrderList(String orderNo, Integer type, String staffNumber, Integer tradeId, String logisticsOrderNo, String beginCreationTime, String endCreationTime, Integer page, Integer size);

    void updateTypeByOrderNo(String orderNo) throws Exception;

    void uploadLogisticsOrderNo(List<OrderModel> orderModels) throws Exception;

    PageInfo<OrderItemDTO> getOrderItemList(String orderNo, String orderItemNo, Integer timeWay, Integer orderUser, Integer orderItemType, String beginCreationTime, String endCreationTime, Integer shippWay, Integer payWay, Integer page, Integer size);

    PageInfo<OrderAssessDTO> getOrderAssessList(String orderItemNo, Integer evaluatorId, Integer starRating, Integer type, String beginCreationTime, String endCreationTime, Integer page, Integer size);

    void updateAssessTypeById(OrderAssessDTO orderAssessDTO);

    PageInfo<OrderDeliveryDTO> getOrderDeliveryList(String orderItemNo, Integer page, Integer size);
}
