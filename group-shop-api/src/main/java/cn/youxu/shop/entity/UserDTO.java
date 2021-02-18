package cn.youxu.shop.entity;

import lombok.Data;

@Data
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private Integer userRoleId;
    private Integer isDeleted;
}
