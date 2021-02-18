package cn.youxu.shop.service;

import cn.youxu.shop.entity.StaffDTO;
import cn.youxu.shop.entity.UserVO;

public interface LoginService {
    StaffDTO getUser(String token);

    String creatToken(UserVO userVO) throws Exception;
}
