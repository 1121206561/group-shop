package cn.youxu.shop.mapper;

import cn.youxu.shop.entity.GoodSortDTO;
import cn.youxu.shop.entity.GoodSortVO;
import cn.youxu.shop.entity.GoodTradeDTO;
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

    List<GoodTradeDTO> getGoodsTrade(@Param("tradeName") String tradeName, @Param("tradeJobNumber") String tradeJobNumber ,@Param("sortId") Integer sortId);

    int updateTradeTypeById(@Param("id") Integer id, @Param("isGrounding") Integer isGrounding, @Param("isExplosive") Integer isExplosive);

    int deleteGoodTradeById(@Param("id") Integer id);

    void addGoodTrade(@Param("goodTradeDTO") GoodTradeDTO goodTradeDTO);

    void updateGoodTradeById(@Param("goodTradeDTO") GoodTradeDTO goodTradeDTO);

    void updateGoodTradeItemByTradeId(@Param("goodTradeDTO") GoodTradeDTO goodTradeDTO);

    void addGoodTradeItem(@Param("goodTradeDTO") GoodTradeDTO goodTradeDTO);
}
