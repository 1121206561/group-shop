package cn.youxu.shop.controller;

import cn.youxu.shop.common.CommonResponse;
import cn.youxu.shop.entity.GoodSortDTO;
import cn.youxu.shop.entity.GoodSortVO;
import cn.youxu.shop.service.GoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "商品管理接口实现")
@RequestMapping("/good")
@CrossOrigin
public class GoodController {

    @Autowired
    private GoodService goodService;

    @GetMapping("/sort")
    @ApiOperation("商品分类查询")
    public CommonResponse getGoodsSort(@RequestParam(required = false) Integer maxLevel,
                                       @RequestParam(required = false, defaultValue = "1") Integer page,
                                       @RequestParam(required = false, defaultValue = "100") Integer size) {
        try {
            return CommonResponse.ok().data("content", goodService.getGoodsSort(maxLevel, page, size));
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @PostMapping("/updateIsShow")
    @ApiOperation("商品显示状态更新")
    public CommonResponse updateIsShow(@RequestParam Integer isShow, @RequestParam Integer id) {
        try {
            goodService.updateIsShow(isShow, id);
            return CommonResponse.ok();
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @PostMapping("/deleteGoodsById")
    @ApiOperation("删除商品分类")
    public CommonResponse deleteGoodsById(@RequestParam Integer id) {
        try {
            goodService.deleteGoodsById(id);
            return CommonResponse.ok();
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @PostMapping("/updateOrAddEmployeeById")
    @ApiOperation("编辑商品分类")
    public CommonResponse updateOrAddEmployeeById(@RequestBody(required = false) GoodSortVO goodSortVO) {
        try {
            goodService.updateOrAddEmployeeById(goodSortVO);
            return CommonResponse.ok();
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @GetMapping("/trade")
    @ApiOperation("商品详情查询")
    public CommonResponse getGoodsTrade(@RequestParam(required = false) String tradeName,
                                        @RequestParam(required = false) Integer sortId,
                                        @RequestParam(required = false, defaultValue = "1") Integer page,
                                        @RequestParam(required = false, defaultValue = "100") Integer size) {
        try {
            return CommonResponse.ok().data("content", goodService.getGoodsTrade(tradeName, sortId, page, size));
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }
}
