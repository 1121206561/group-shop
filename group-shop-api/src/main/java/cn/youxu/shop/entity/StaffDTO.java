package cn.youxu.shop.entity;

import lombok.Data;

@Data
public class StaffDTO {
    private Integer id;
    private String name;
    private Integer jobNumber;
    private Integer sexId;
    private String sex;
    private String avatar;
    private Integer userRoleId;
    private String userRole;
}
