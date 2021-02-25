package cn.youxu.shop.entity;

import lombok.Data;

@Data
public class EssayDTO {
    private Integer id;
    private Integer essaySortId;
    private String essayName;
    private String essaySortName;
    private String essayContent;
    private String essayPicture;
    private Integer sortNumber;
    private Integer isDeleted;
}
