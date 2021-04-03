package cn.youxu.shop.wepyEntity;

import lombok.Data;

import java.util.List;

@Data
public class FloordataDTO {
    private Floortitle floor_title;
    private List<ProductList> product_list;
}
