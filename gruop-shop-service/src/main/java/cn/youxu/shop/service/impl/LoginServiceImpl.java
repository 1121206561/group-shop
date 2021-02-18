package cn.youxu.shop.service.impl;

import cn.youxu.shop.entity.StaffDTO;
import cn.youxu.shop.entity.UserDTO;
import cn.youxu.shop.entity.UserVO;
import cn.youxu.shop.exception.ServiceException;
import cn.youxu.shop.mapper.LoginMapper;
import cn.youxu.shop.service.LoginService;
import cn.youxu.shop.utils.JWTUtil;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    public LoginMapper loginMapper;
    @Override
    public StaffDTO getUser(String token) {
        return loginMapper.getStaff(JWTUtil.verifyToken(token));
    }

    @Override
    public String creatToken(UserVO userVO) throws Exception {
        UserDTO user = loginMapper.getUser(userVO.getUsername());
        if (user == null || !user.getPassword().equals(userVO.getPassword())){
            throw new ServiceException("用户名或密码不正确");
        }
        return JWTUtil.createToken(user.getUsername());
    }
}
