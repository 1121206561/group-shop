package cn.youxu.shop.entity;

import lombok.Data;

import java.util.Date;

@Data
public class GoodSortVO {
    private Integer id;
    private Integer superiorId;
    private String superiorName;
    private String categoryName;
    private String categoryIcon;
    private String themePicture;
    private Integer sortNumber;
    private String effectiveTime;
    private Integer isShow;
    private Integer isDeleted;
    private Integer isMaxLevel;

    public void updateCategoryName() {
        if (this.id != null && !this.isMaxLevel.equals(GoodSortDTO.MAX_LEVEL))
            this.categoryName = this.categoryName.substring(4);
    }
}
