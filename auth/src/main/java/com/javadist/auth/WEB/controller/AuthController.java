package com.javadist.auth.WEB.controller;

import com.javadist.auth.WEB.config.JwtTokenUtil;
import com.javadist.auth.WEB.controller.DTO.UserDto;
import com.javadist.auth.WEB.controller.DTO.UserWithTokenDto;
import com.javadist.auth.business.service.UserService;
import com.javadist.auth.infrastructure.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @PostMapping(value = "/register")
    public User create(@RequestBody UserDto userDto) {
        User user = new User();
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        return userService.save(user);
    }

    @PostMapping(value = "/login")
    public UserWithTokenDto login(@RequestBody UserDto request) {
        User user = (User) userService.loadUserByUsername(request.getUsername(), request.getPassword());
        return new UserWithTokenDto(user.getId(), user.getUsername(), jwtTokenUtil.generateToken(user));
    }
}
