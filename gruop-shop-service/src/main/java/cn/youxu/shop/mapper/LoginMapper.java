package cn.youxu.shop.mapper;

import cn.youxu.shop.entity.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    UserDTO getUser(String username);
}
