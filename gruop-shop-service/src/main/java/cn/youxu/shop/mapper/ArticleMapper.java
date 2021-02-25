package cn.youxu.shop.mapper;

import cn.youxu.shop.entity.ArticleSortDTO;
import cn.youxu.shop.entity.EssayDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    List<ArticleSortDTO> getArticlesSort(@Param("maxLevel") Integer maxLevel);

    int updateIsShow(@Param("id") Integer id, @Param("isShow") Integer isShow);

    void deleteArticlesById(@Param("id") Integer id, @Param("superiorId") Integer superiorId);

    ArticleSortDTO selectArticleById(Integer id);

    Integer getMaxSuppId();

    void updateOrAddArticleById(@Param("articleSortDTO") ArticleSortDTO articleSortDTO);

    List<EssayDTO> getEssayList(@Param("essayName") String essayName, @Param("sortId") String sortId);

    void deleteEssayById(@Param("id") Integer id);

    void updateOrAddEssayById(@Param("essayDTO") EssayDTO essayDTO);
}
