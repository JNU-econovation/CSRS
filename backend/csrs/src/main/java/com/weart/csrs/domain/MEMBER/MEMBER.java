package com.weart.csrs.domain.MEMBER;

import com.weart.csrs.domain.BaseTimeEntity;
import com.weart.csrs.service.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class MEMBER extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public MEMBER(int id, String name, String email, String picture, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public MEMBER update(String name, String email, Role role) {
        this.name = name;
        this.email = email;
        this.role = role;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

}