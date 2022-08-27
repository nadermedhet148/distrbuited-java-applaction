package com.javadist.auth.WEB.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserWithTokenDto {

    private  Long userId;
    private  String username;
    private  String token;
}
