package cn.youxu.shop.mapper;

import cn.youxu.shop.entity.StaffDTO;
import cn.youxu.shop.entity.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    UserDTO getUser(@Param("username") String username);


    StaffDTO getStaff(@Param("username") String username);
}
