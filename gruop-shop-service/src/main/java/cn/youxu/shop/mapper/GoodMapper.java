package cn.youxu.shop.mapper;

import cn.youxu.shop.entity.GoodSortDTO;
import cn.youxu.shop.entity.GoodSortVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodMapper {

    List<GoodSortDTO> getGoodsSort(@Param("maxLevel") Integer maxLevel);

    int updateIsShow(@Param("id") Integer id, @Param("isShow") Integer isShow);

    GoodSortDTO selectGoodById(@Param("id") Integer id);

    //Integer 类型 的 <if test xx = ''"> 会默认匹配 0 
    void deleteGoodsById(@Param("id") Integer id, @Param("superiorId") Integer superiorId);

    void updateOrAddEmployeeById(@Param("goodSortVO") GoodSortVO goodSortVO);

    Integer getMaxSuppId();
}
