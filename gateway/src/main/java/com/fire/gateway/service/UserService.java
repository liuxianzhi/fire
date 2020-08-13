package com.fire.gateway.service;

import com.fire.gateway.model.vo.UserVO;

public interface UserService {

    UserVO findUserByUsername(String username);
}
