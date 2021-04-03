package cn.youxu.wepy.shop.mapper;

import cn.youxu.shop.wepyEntity.CatitemDTO;
import cn.youxu.shop.wepyEntity.Floortitle;
import cn.youxu.shop.wepyEntity.ProductList;
import cn.youxu.shop.wepyEntity.SwiperDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeMapper {

    List<SwiperDTO> getSwiperdata();

    List<CatitemDTO> getCatitems();

    List<Floortitle> getFloortitle();

    List<ProductList> getProductList(@Param("id") Integer id);
}
