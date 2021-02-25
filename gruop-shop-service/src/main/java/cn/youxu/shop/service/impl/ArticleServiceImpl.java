package cn.youxu.shop.service.impl;

import cn.youxu.shop.entity.ArticleSortDTO;
import cn.youxu.shop.entity.EssayDTO;
import cn.youxu.shop.entity.GoodSortDTO;
import cn.youxu.shop.entity.GoodSortVO;
import cn.youxu.shop.exception.ServiceException;
import cn.youxu.shop.mapper.ArticleMapper;
import cn.youxu.shop.service.ArticleService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static cn.youxu.shop.group_enum.isShowEnum.IS_SHOW;
import static cn.youxu.shop.group_enum.isShowEnum.NOT_IS_SHOW;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public PageInfo getArticlesSort(Integer maxLevel, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<ArticleSortDTO> articleSortDTOS = articleMapper.getArticlesSort(maxLevel);
        articleSortDTOS.forEach(ArticleSortDTO::updateArticleName);
        return new PageInfo<>(articleSortDTOS);
    }

    @Override
    @Transactional
    public void updateIsShow(Integer isShow, Integer id) throws Exception {
        if (articleMapper.updateIsShow(id, isShow.equals(IS_SHOW.getCode()) ? IS_SHOW.getCode() : NOT_IS_SHOW.getCode()) != 1) {
            throw new ServiceException("更新失败");
        }
    }

    @Override
    public void deleteArticlesById(Integer id) {
        ArticleSortDTO articleSortDTO = articleMapper.selectArticleById(id);
        Integer superiorId = null;
        //如果他是顶层分类，那么删除链
        if (articleSortDTO.getIsMaxLevel().equals(GoodSortDTO.MAX_LEVEL)) {
            superiorId = articleSortDTO.getSuperiorId();
            articleMapper.deleteArticlesById(null, superiorId);
        } else {
            articleMapper.deleteArticlesById(id, superiorId);
        }
    }

    @Override
    public void updateOrAddArticleById(ArticleSortDTO articleSortDTO) {
        articleSortDTO.addArticleName();
        if (articleSortDTO.getId() == null && articleSortDTO.getIsMaxLevel() == 0) {
            articleSortDTO.setSuperiorId(articleMapper.getMaxSuppId() + 1);
        }
        articleMapper.updateOrAddArticleById(articleSortDTO);
    }

    @Override
    public PageInfo<EssayDTO> getEssayList(String essayName, String sortId, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>( articleMapper.getEssayList(essayName,sortId));
    }

    @Override
    public void deleteEssayById(Integer id) {
        articleMapper.deleteEssayById(id);
    }

    @Override
    public void updateOrAddEssayById(EssayDTO essayDTO) {
        articleMapper.updateOrAddEssayById(essayDTO);
    }

}
