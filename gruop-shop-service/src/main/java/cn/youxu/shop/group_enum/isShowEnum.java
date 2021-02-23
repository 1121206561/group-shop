package cn.youxu.shop.group_enum;

import lombok.Data;

public enum isShowEnum {
    IS_SHOW(0, "显示"),
    NOT_IS_SHOW(1, "不显示");
    private Integer code;
    private String name;

    isShowEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
