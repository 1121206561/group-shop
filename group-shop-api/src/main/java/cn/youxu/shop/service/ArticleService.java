package cn.youxu.shop.service;


import cn.youxu.shop.entity.ArticleSortDTO;
import cn.youxu.shop.entity.EssayDTO;
import com.github.pagehelper.PageInfo;

public interface ArticleService {
    PageInfo<ArticleSortDTO> getArticlesSort(Integer maxLevel, Integer page, Integer size);

    void updateIsShow(Integer isShow, Integer id) throws Exception;

    void deleteArticlesById(Integer id) throws Exception;

    void updateOrAddArticleById(ArticleSortDTO articleSortDTO);

    PageInfo<EssayDTO> getEssayList(String essayName, String sortId, Integer page, Integer size);

    void deleteEssayById(Integer id);

    void updateOrAddEssayById(EssayDTO essayDTO);
}
