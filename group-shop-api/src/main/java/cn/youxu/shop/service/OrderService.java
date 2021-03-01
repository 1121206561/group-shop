package cn.youxu.shop.service;

import cn.youxu.shop.entity.OrderDTO;
import cn.youxu.shop.entity.OrderModel;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderService {
    PageInfo<OrderDTO> getOrderList(String orderNo, Integer type, String staffNumber, Integer tradeId, String logisticsOrderNo, String beginCreationTime, String endCreationTime, Integer page, Integer size);

    void updateTypeByOrderNo(String orderNo) throws Exception;

    void uploadLogisticsOrderNo(List<OrderModel> orderModels) throws Exception;
}
