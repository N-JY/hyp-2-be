package com.hypermedicus.payload.response;

import com.hypermedicus.rds.entity.AccountClassificationEntity;
import com.hypermedicus.rds.entity.AccountEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountResponse {
    private String passwordUpdatedDatetime;
    private String passwordNoticeDatetime;
    private String createdDatetime;
    private String lastLoginDatetime;
    private String loginCount;
    private String refreshToken;
    private String status;
    private String terminationDatetime;
    private String name;
    private String email;
    private String phone;
    private String nation;
    private String hospital;
    private String department;
    
    public static AccountResponse toResponse(AccountEntity accountEntity, AccountClassificationEntity accountClassificationEntity) {
        return AccountResponse.builder()
        .passwordUpdatedDatetime(accountEntity.getPasswordUpdatedDatetime())
        .passwordNoticeDatetime(accountEntity.getPasswordNoticeDatetime())
        .createdDatetime(accountEntity.getCreatedDatetime())
        .lastLoginDatetime(accountEntity.getLastLoginDatetime())
        .loginCount(accountEntity.getLoginCount())
        .refreshToken(accountEntity.getRefreshToken())
        .status(accountEntity.getStatus())
        .terminationDatetime(accountEntity.getTerminationDatetime())
        .name(accountClassificationEntity.getName())        
        .email(accountClassificationEntity.getEmail())
        .phone(accountClassificationEntity.getPhone())
        .nation(accountClassificationEntity.getNation())
        .hospital(accountClassificationEntity.getHospital())
        .department(accountClassificationEntity.getDepartment())
        .build();
    }
}
