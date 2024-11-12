package com.hypermedicus.rds.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "account")
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class AccountEntity {
    @Id
    @Column(nullable = false, unique = true)
    private UUID uuid;

    @Column(length =  128)
    private String password;

    @Builder.Default
    @Column(name = "password_updated_datetime", length = 14, nullable = true, columnDefinition = "VARCHAR(14) DEFAULT '99991231235959'")
    private String passwordUpdatedDatetime = "99991231235959";

    @Builder.Default
    @Column(name = "password_notice_datetime", length = 14, nullable = true, columnDefinition = "VARCHAR(14) DEFAULT '99991231235959'")
    private String passwordNoticeDatetime = "99991231235959";

    @Builder.Default
    @Column(name = "created_datetime", length = 14, nullable = true, columnDefinition = "VARCHAR(14) DEFAULT '99991231235959'")
    private String createdDatetime = "99991231235959";

    @Builder.Default
    @Column(name = "last_login_datetime", length = 14, nullable = true, columnDefinition = "VARCHAR(14) DEFAULT '99991231235959'")
    private String lastLoginDatetime = "99991231235959";

    @Builder.Default
    @Column(name = "login_count", length = 10, nullable = true, columnDefinition = "VARCHAR(10) DEFAULT '0'")
    private String loginCount = "0";

    @Column(name = "refresh_token", length = 512)
    private String refreshToken;

    @Builder.Default
    @Column(length = 1, nullable = true, columnDefinition = "VARCHAR(1) DEFAULT 'A'")
    private String status = "A";

    @Builder.Default    
    @Column(name = "termination_datetime", length = 14, nullable = true, columnDefinition = "VARCHAR(14) DEFAULT '99991231235959'")
    private String terminationDatetime = "99991231235959";
    
}