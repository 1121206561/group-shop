package cn.youxu.wepy.shop.service.impl;

import cn.youxu.shop.wepyEntity.*;
import cn.youxu.wepy.shop.mapper.HomeMapper;
import cn.youxu.wepy.shop.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeMapper homeMapper;
    @Override
    public List<SwiperDTO> getSwiperdata() {
        List<SwiperDTO> swiperDTOS = homeMapper.getSwiperdata();
        swiperDTOS.forEach(c -> {
            c.setNavigator_url("/pages/goods_detail?goods_id=" + c.getId());
        });
        return swiperDTOS;
    }

    @Override
    public List<CatitemDTO> getCatitems() {
        List<CatitemDTO> catitemDTOS = homeMapper.getCatitems();
        catitemDTOS.forEach(c -> {
            c.setNavigator_url("/pages/goods_list?query=" + c.getName());
        });
        return catitemDTOS;
    }

    @Override
    public List<FloordataDTO> getFloordata() {
        List<Floortitle> floortitles = homeMapper.getFloortitle();
        List<FloordataDTO> floordataDTOS = new ArrayList<>();
        floortitles.forEach(c -> {
            FloordataDTO floordataDTO = new FloordataDTO();
            floordataDTO.setFloor_title(c);
            List<ProductList> productLists = homeMapper.getProductList(c.getId());
            productLists.forEach(p -> {
                p.setNavigator_url("/pages/goods_list?query="+p.getName());
                p.setImage_width("200");
            });
            floordataDTO.setProduct_list(productLists);
            floordataDTOS.add(floordataDTO);
        });
        return floordataDTOS;
    }
}
