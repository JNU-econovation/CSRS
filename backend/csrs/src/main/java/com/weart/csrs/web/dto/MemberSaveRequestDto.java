//package com.weart.csrs.web.dto;
//
//import com.weart.csrs.domain.member.Member;
//import lombok.Builder;
//import lombok.Getter;
//
//@Getter
//public class MemberSaveRequestDto {
//    private String username;
//    private String password;
//    private String email;
//
//    @Builder
//    public MemberSaveRequestDto(String username, String password, String email) {
//        this.username = username;
//        this.password = password;
//        this.email = email;
//    }
//
//    public Member toEntity() {
//        return Member.builder()
//                .username(username)
//                .password(password)
//                .email(email).
//                build();
//    }
//}
