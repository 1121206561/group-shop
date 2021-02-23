package cn.youxu.shop.service;

import cn.youxu.shop.entity.GoodSortDTO;
import cn.youxu.shop.entity.GoodSortVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface GoodService {
    PageInfo<GoodSortDTO> getGoodsSort(Integer maxLevel,Integer page, Integer size);

    void updateIsShow(Integer isShow, Integer id) throws Exception;

    void deleteGoodsById(Integer id);

    void updateOrAddEmployeeById(GoodSortVO goodSortVO);

    PageInfo<GoodSortDTO> getGoodsTrade(String tradeName, Integer sortId, Integer page, Integer size);
}
