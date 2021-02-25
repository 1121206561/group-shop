package cn.youxu.shop.service;

import cn.youxu.shop.entity.GoodSortDTO;
import cn.youxu.shop.entity.GoodSortVO;
import cn.youxu.shop.entity.GoodTradeDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface GoodService {
    PageInfo<GoodSortDTO> getGoodsSort(Integer maxLevel,Integer page, Integer size);

    void updateIsShow(Integer isShow, Integer id) throws Exception;

    void deleteGoodsById(Integer id);

    void updateOrAddEmployeeById(GoodSortVO goodSortVO);

    PageInfo<GoodTradeDTO> getGoodsTrade(String tradeName, Integer sortId,String tradeJobNumber,Integer page, Integer size);

    void updateTradeTypeById(Integer id, Integer isGrounding, Integer isExplosive) throws Exception;

    void deleteGoodTradeById(Integer id) throws Exception;

    void updateOrAddGoodTradeById(GoodTradeDTO goodTradeDTO) throws Exception;
}
