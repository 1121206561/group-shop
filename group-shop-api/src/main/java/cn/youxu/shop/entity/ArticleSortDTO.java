package cn.youxu.shop.entity;

import lombok.Data;

@Data
public class ArticleSortDTO {
    public static final Integer MAX_LEVEL = 0;

    private Integer id;
    private Integer superiorId;
    private String superiorName;
    private String articleName;
    private Integer sortNumber;
    private Integer isShow;
    private Integer isDeleted;
    private Integer isMaxLevel;

    public void updateArticleName() {
        if (!this.isMaxLevel.equals(MAX_LEVEL)) {
            this.articleName = "|---" + this.articleName;
        }
        if (this.isMaxLevel.equals(MAX_LEVEL)) {
            this.superiorName = "顶级分类";
        }
    }

    public void addArticleName() {
        if (this.id != null && !this.isMaxLevel.equals(GoodSortDTO.MAX_LEVEL))
            this.articleName = this.articleName.substring(4);
    }
}
