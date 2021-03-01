package cn.youxu.shop.controller;

import cn.youxu.shop.common.CommonResponse;
import cn.youxu.shop.entity.OrderModel;
import cn.youxu.shop.service.OrderService;
import cn.youxu.shop.utils.PoiUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api(description = "订单接口实现")
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getOrderList")
    @ApiOperation("订单查询")
    public CommonResponse getOrderList(@RequestParam(required = false) String orderNo,
                                       @RequestParam(required = false) String staffNumber,
                                       @RequestParam(required = false) Integer tradeId,
                                       @RequestParam(required = false) String beginCreationTime,
                                       @RequestParam(required = false) String endCreationTime,
                                       @RequestParam(required = false) String logisticsOrderNo,
                                       @RequestParam(required = false) Integer type,
                                       @RequestParam(required = false, defaultValue = "1") Integer page,
                                       @RequestParam(required = false, defaultValue = "100") Integer size) {
        try {
            return CommonResponse.ok().data("content", orderService.getOrderList(orderNo, type, staffNumber, tradeId,
                    logisticsOrderNo, beginCreationTime, endCreationTime, page, size));
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @PostMapping("/updateTypeByOrderNo")
    @ApiOperation("订单状态变更")
    public CommonResponse updateTypeByOrderNo(@RequestParam String orderNo) {
        try {
            orderService.updateTypeByOrderNo(orderNo);
            return CommonResponse.ok();
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @PostMapping("/uploadLogisticsOrderNo")
    @ApiOperation("批量导入物流信息")
    public CommonResponse uploadLogisticsOrderNo(MultipartFile file) {
        try {
            PoiUtil poiUtil = new PoiUtil();
            poiUtil.checkFile(file);
            Workbook workBook = poiUtil.getWorkBook(file);
            orderService.uploadLogisticsOrderNo(poiUtil.uploadExcel(workBook, OrderModel.class));
            return CommonResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResponse.error();
        }
    }

    @GetMapping("/getOrderItemList")
    @ApiOperation("订单详情查询")
    public CommonResponse getOrderItemList(@RequestParam(required = false) String orderNo,
                                           @RequestParam(required = false) String orderItemNo,
                                           @RequestParam(required = false) Integer timeWay,
                                           @RequestParam(required = false) Integer orderUser,
                                           @RequestParam(required = false) String beginCreationTime,
                                           @RequestParam(required = false) String endCreationTime,
                                           @RequestParam(required = false) Integer orderItemType,
                                           @RequestParam(required = false) Integer shippWay,
                                           @RequestParam(required = false) Integer payWay,
                                           @RequestParam(required = false, defaultValue = "1") Integer page,
                                           @RequestParam(required = false, defaultValue = "100") Integer size) {
        try {
            return CommonResponse.ok().data("content", orderService.getOrderItemList(orderNo, orderItemNo, timeWay, orderUser,
                    orderItemType, beginCreationTime, endCreationTime, shippWay, payWay, page, size));
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

}
