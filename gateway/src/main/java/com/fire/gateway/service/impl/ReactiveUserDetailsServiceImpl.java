package com.fire.gateway.service.impl;

import com.fire.gateway.model.vo.UserVO;
import com.fire.gateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ReactiveUserDetailsServiceImpl implements ReactiveUserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public Mono<UserDetails> findByUsername(String s) {
        UserVO userVO = userService.findUserByUsername(s);
        UserDetails user = User.withUsername(userVO.getUsername())
                .password(userVO.getPassword())
                .roles(userVO.getRole())
                .build();
        return Mono.just(user);
    }
}
