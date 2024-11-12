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
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.UUID;

@Entity
@Table(name = "account_verification")
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class AccountVerificationEntity {

    @Id
    @Column(nullable = false, unique = true)
    private UUID uuid;

    @Column(length = 10, nullable = true)
    private String sequence;

    @Column(length = 8, nullable = true)
    private String classification;

    @Column(length = 255, nullable = true)
    private String classificationId;

    @Column(length = 1, nullable = true)
    private String verification;

    @Column(length = 8, nullable = true)
    private String verificationCode;

    @Builder.Default
    @Column(name = "verification_datetime", length = 14, nullable = true, columnDefinition = "VARCHAR(14) DEFAULT '99991231235959'")
    private String verificationDatetime = "99991231235959";

    @Builder.Default
    @Column(length = 1, nullable = true, columnDefinition = "VARCHAR(1) DEFAULT 'A'")
    private String status = "A";
}
