package cn.youxu.shop.mapper;

import cn.youxu.shop.entity.OrderDTO;
import cn.youxu.shop.entity.OrderModel;
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
}