package com.weart.csrs.web.dto;

import com.weart.csrs.domain.MEMBER.MEMBER;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MEMBERDto {
    private int id;
    private String name;
    private String email;

    //MEMBER 객체로 변환
    public MEMBER toEntity(){
        return MEMBER.builder()
                .id(id)
                .name(name)
                .email(email)
                .build();
    }

    @Builder
    public MEMBERDto(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}
