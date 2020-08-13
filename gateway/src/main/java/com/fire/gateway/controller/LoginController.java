package com.fire.gateway.controller;

import com.fire.gateway.model.dto.LoginDTO;
import com.fire.gateway.service.impl.ReactiveUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class LoginController {

    @Autowired
    private ReactiveUserDetailsServiceImpl reactiveUserDetailsServiceImpl;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        Mono<UserDetails> admin = reactiveUserDetailsServiceImpl.findByUsername("admin");
        String password = admin.block().getPassword();
        String matchPassword = loginDTO.getPassword();
        if (password.equals(matchPassword)) {
            return "login success get a token";
        }
        return "用户名密码错误";
    }
}
