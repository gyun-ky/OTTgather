package com.example.homekiri.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostSignInReq {
    private String email;
    private String pwd;
    private String nickName;
}
