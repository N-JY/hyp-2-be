package com.hypermedicus.rds.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.UUID;

@Entity
@Table(name = "account_classification")
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class AccountClassificationEntity {
    @Id
    @Column(nullable = false, unique = true)
    private UUID uuid;

    @Column(length = 30, nullable = true)
    private String name;

    @Column(length = 30, nullable = true)
    private String email;

    @Column(length = 15, nullable = true)
    private String phone;

    @Column(length = 30, nullable = true)
    private String nation;

    @Column(length = 30, nullable = true)
    private String hospital;

    @Column(length = 30, nullable = true)
    private String department;
}
