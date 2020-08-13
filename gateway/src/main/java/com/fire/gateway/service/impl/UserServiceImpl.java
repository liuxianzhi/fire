package com.fire.gateway.service.impl;

import com.fire.gateway.model.vo.UserVO;
import com.fire.gateway.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserVO findUserByUsername(String username) {
        UserVO userVO = new UserVO();
        userVO.setUsername("admin");
        userVO.setPassword("1234");
        userVO.setRole("ADMIN");
        return userVO;
    }
}
