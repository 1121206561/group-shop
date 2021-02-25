package cn.youxu.shop.controller;

import cn.youxu.shop.common.CommonResponse;
import cn.youxu.shop.entity.ArticleSortDTO;
import cn.youxu.shop.entity.EssayDTO;
import cn.youxu.shop.entity.GoodSortVO;
import cn.youxu.shop.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "文章管理接口实现")
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/sort")
    @ApiOperation("文章分类查询")
    public CommonResponse getArticlesSort(@RequestParam(required = false) Integer maxLevel,
                                          @RequestParam(required = false, defaultValue = "1") Integer page,
                                          @RequestParam(required = false, defaultValue = "100") Integer size) {
        try {
            return CommonResponse.ok().data("content", articleService.getArticlesSort(maxLevel, page, size));
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @PostMapping("/updateIsShow")
    @ApiOperation("文章显示状态更新")
    public CommonResponse updateIsShow(@RequestParam Integer isShow, @RequestParam Integer id) {
        try {
            articleService.updateIsShow(isShow, id);
            return CommonResponse.ok();
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @PostMapping("/deleteArticlesById")
    @ApiOperation("删除文章分类")
    public CommonResponse deleteArticlesById(@RequestParam Integer id) {
        try {
            articleService.deleteArticlesById(id);
            return CommonResponse.ok();
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @PostMapping("/updateOrAddArticleById")
    @ApiOperation("编辑新增文章分类")
    public CommonResponse updateOrAddArticleById(@RequestBody(required = false) ArticleSortDTO articleSortDTO) {
        try {
            articleService.updateOrAddArticleById(articleSortDTO);
            return CommonResponse.ok();
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @GetMapping("/getEssayList")
    @ApiOperation("文章查询")
    public CommonResponse getEssayList(@RequestParam(required = false) String essayName,
                                        @RequestParam(required = false) String sortId,
                                        @RequestParam(required = false, defaultValue = "1") Integer page,
                                        @RequestParam(required = false, defaultValue = "100") Integer size) {
        try {
            return CommonResponse.ok().data("content", articleService.getEssayList(essayName, sortId, page, size));
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @PostMapping("/deleteEssayById")
    @ApiOperation("删除文章")
    public CommonResponse deleteEssayById(@RequestParam Integer id) {
        try {
            articleService.deleteEssayById(id);
            return CommonResponse.ok();
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @PostMapping("/updateOrAddEssayById")
    @ApiOperation("编辑新增文章")
    public CommonResponse updateOrAddEssayById(@RequestBody(required = false)EssayDTO essayDTO) {
        try {
            articleService.updateOrAddEssayById(essayDTO);
            return CommonResponse.ok();
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }


}
