package cn.youxu.wepy.shop.service;

import cn.youxu.shop.wepyEntity.CatitemDTO;
import cn.youxu.shop.wepyEntity.FloordataDTO;
import cn.youxu.shop.wepyEntity.SwiperDTO;

import java.util.List;

public interface HomeService {
    List<SwiperDTO> getSwiperdata();

    List<CatitemDTO> getCatitems();

    List<FloordataDTO> getFloordata();
}
