package com.umc.yourun.converter;

import com.umc.yourun.domain.User;
import com.umc.yourun.dto.user.UserRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public static User toMember(UserRequestDTO.JoinDto request) {

        return User.builder()
                .nickname(request.nickname())
                .email(request.email())   // 추가된 코드
                .password(request.password())   // 추가된 코드
                .build();
    }
}
