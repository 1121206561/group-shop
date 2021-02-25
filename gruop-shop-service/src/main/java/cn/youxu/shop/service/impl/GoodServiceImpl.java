package cn.youxu.shop.service.impl;

import cn.youxu.shop.entity.GoodSortDTO;
import cn.youxu.shop.entity.GoodSortVO;
import cn.youxu.shop.entity.GoodTradeDTO;
import cn.youxu.shop.entity.StaffDTO;
import cn.youxu.shop.exception.ServiceException;
import cn.youxu.shop.mapper.GoodMapper;
import cn.youxu.shop.service.GoodService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static cn.youxu.shop.group_enum.isShowEnum.IS_SHOW;
import static cn.youxu.shop.group_enum.isShowEnum.NOT_IS_SHOW;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;


    @Override
    public PageInfo<GoodSortDTO> getGoodsSort(Integer maxLevel, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<GoodSortDTO> goodsSort = goodMapper.getGoodsSort(maxLevel);
        goodsSort.forEach(GoodSortDTO::updateCategoryName);
        return new PageInfo<>(goodsSort);
    }

    @Override
    @Transactional
    public void updateIsShow(Integer isShow, Integer id) throws Exception {
        if (goodMapper.updateIsShow(id, isShow.equals(IS_SHOW.getCode()) ? IS_SHOW.getCode() : NOT_IS_SHOW.getCode()) != 1) {
            throw new ServiceException("更新失败");
        }
    }

    @Override
    public void deleteGoodsById(Integer id) {
        GoodSortDTO goodSortDTO = goodMapper.selectGoodById(id);
        Integer superiorId = null;
        //如果他是顶层分类，那么删除链
        if (goodSortDTO.getIsMaxLevel().equals(GoodSortDTO.MAX_LEVEL)) {
            superiorId = goodSortDTO.getSuperiorId();
            goodMapper.deleteGoodsById(null, superiorId);
        } else {
            goodMapper.deleteGoodsById(id, superiorId);
        }
    }

    @Override
    public void updateOrAddEmployeeById(GoodSortVO goodSortVO) {
        goodSortVO.updateCategoryName();
        if (goodSortVO.getId() == null) {
            goodSortVO.setSuperiorId(goodMapper.getMaxSuppId() + 1);
        }
        goodMapper.updateOrAddEmployeeById(goodSortVO);
    }

    @Override
    public PageInfo<GoodTradeDTO> getGoodsTrade(String tradeName, Integer sortId, String tradeJobNumber, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(goodMapper.getGoodsTrade(tradeName, tradeJobNumber, sortId));
    }

    @Override
    @Transactional
    public void updateTradeTypeById(Integer id, Integer isGrounding, Integer isExplosive) throws Exception {
        if (goodMapper.updateTradeTypeById(id, isGrounding, isExplosive) > 1) {
            throw new ServiceException("更新异常");
        }
    }

    @Override
    @Transactional
    public void deleteGoodTradeById(Integer id) throws Exception {
        goodMapper.deleteGoodTradeById(id);
    }

    @Override
    @Transactional
    public void updateOrAddGoodTradeById(GoodTradeDTO goodTradeDTO) throws Exception {
        if (goodTradeDTO.getId() != null) {
            goodMapper.updateGoodTradeById(goodTradeDTO);
            goodMapper.updateGoodTradeItemByTradeId(goodTradeDTO);
        } else {
            goodMapper.addGoodTrade(goodTradeDTO);
            goodMapper.addGoodTradeItem(goodTradeDTO);
        }
    }
}
