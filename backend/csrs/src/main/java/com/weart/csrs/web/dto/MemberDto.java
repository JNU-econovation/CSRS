package com.weart.csrs.web.dto;

import com.weart.csrs.domain.member.Member;
import com.weart.csrs.domain.member.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;

    //MEMBER 객체로 변환
    public Member toMember() {
        return Member.builder()
                .id(id)
                .name(name)
                .password(password)
                .role(role)
                .build();
    }

    @Builder
    public MemberDto(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

}
