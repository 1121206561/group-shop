package cn.youxu.shop.entity;

import lombok.Data;

@Data
public class GoodSortDTO {

    public static final Integer MAX_LEVEL = 0;

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
        if (!this.isMaxLevel.equals(MAX_LEVEL)) {
            this.categoryName = "|---" + this.categoryName;
        }
        if (this.isMaxLevel.equals(MAX_LEVEL)) {
            this.superiorName = "顶级分类";
        }
    }
}
