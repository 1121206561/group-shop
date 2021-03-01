package cn.youxu.shop.service.impl;

import cn.youxu.shop.entity.*;
import cn.youxu.shop.exception.ServiceException;
import cn.youxu.shop.mapper.OrderMapper;
import cn.youxu.shop.service.OrderService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public PageInfo<OrderDTO> getOrderList(String orderNo, Integer type, String staffNumber, Integer tradeId, String logisticsOrderNo, String beginCreationTime, String endCreationTime, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(orderMapper.getOrderList(orderNo, type, staffNumber, tradeId, logisticsOrderNo, beginCreationTime, endCreationTime));
    }

    @Override
    public void updateTypeByOrderNo(String orderNo) throws Exception {
        List<OrderDTO> orderDTOS = orderMapper.getOrderByOrderNo(orderNo);
        if (orderDTOS.size() != 1) {
            throw new ServiceException("订单号异常");
        }
        int orderType = orderDTOS.get(0).getType();
        int afterOrderType = orderType;
        if (afterOrderType != 9) {
            orderType = orderType + 1;
        } else {
            orderType = 0;
        }
        if (orderMapper.updateTypeByOrderNo(afterOrderType, orderType, orderNo) != 1) {
            throw new ServiceException("订单状态异常");
        }
    }

    @Override
    public void uploadLogisticsOrderNo(List<OrderModel> orderModels) throws Exception {
        if (orderModels == null || orderModels.size() == 0) {
            throw new ServiceException("请输入数据");
        }
        List<OrderDTO> orderDTOS = orderMapper.selectByOrderNo(orderModels);
        //判断订单号是否正确
        if (orderDTOS.size() != orderModels.size()) {
            List<OrderModel> orderModels1 = orderModels.stream().filter(c -> !orderDTOS.stream()
                    .collect(Collectors
                            .toMap(OrderDTO::getOrderNo, Function.identity()))
                    .containsKey(c.getOrderNo())).collect(Collectors.toList());
            throw new ServiceException(orderModels1.stream().map(OrderModel::getOrderNo).collect(Collectors.toList()).toString() + "不存在");
        }
        orderMapper.updateLogisticsOrderNo(orderModels);
    }

    @Override
    public PageInfo<OrderItemDTO> getOrderItemList(String orderNo, String orderItemNo, Integer timeWay, Integer orderUser, Integer orderItemType, String beginCreationTime, String endCreationTime, Integer shippWay, Integer payWay, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(orderMapper.getOrderItemList(orderNo, orderItemNo, timeWay, orderUser, orderItemType, beginCreationTime, endCreationTime, shippWay, payWay));

    }

    @Override
    public PageInfo<OrderAssessDTO> getOrderAssessList(String orderItemNo, Integer evaluatorId, Integer starRating, Integer type, String beginCreationTime, String endCreationTime, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(orderMapper.getOrderAssessList(orderItemNo, evaluatorId, starRating, type, beginCreationTime, endCreationTime));
    }

    @Override
    public void updateAssessTypeById(OrderAssessDTO orderAssessDTO) {
        orderMapper.updateAssessTypeById(orderAssessDTO);
    }

    @Override
    public PageInfo<OrderDeliveryDTO> getOrderDeliveryList(String orderItemNo, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(orderMapper.getOrderDeliveryList(orderItemNo));
    }
}
