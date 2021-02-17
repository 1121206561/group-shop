package cn.youxu.shop.service.impl;

import cn.youxu.shop.entity.UserDTO;
import cn.youxu.shop.mapper.LoginMapper;
import cn.youxu.shop.service.LoginService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    public LoginMapper loginMapper;
    @Override
    public UserDTO getUser() {
        return loginMapper.getUser("yu");
    }
}
