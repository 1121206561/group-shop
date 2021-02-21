package cn.youxu.shop.entity;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Integer id;
    private String name;
    private Integer sexId;
    private String jobNumber;
    private Integer userRoleId;
    private String userRole;
    private String sex;
    private String shopCoordinate;
    private String phone;
    private String address;
    private Integer typeId;
    private String type;
    private String shopName;
    private String shopLogo;
    private String shopDescribe;
    private String registerTime;
}
