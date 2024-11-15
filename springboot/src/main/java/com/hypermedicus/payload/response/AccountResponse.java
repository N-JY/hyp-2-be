package com.hypermedicus.payload.response;

import com.hypermedicus.rds.entity.AccountInformationEntity;
import com.hypermedicus.rds.entity.AccountEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class AccountResponse {
    private String passwordUpdatedDatetime;
    private String passwordNoticeDatetime;
    private String createdDatetime;
    private String lastLoginDatetime;
    private String loginCount;
    @Setter
    private String refreshToken;
    private String status;
    private String terminationDatetime;
    private String name;
    private String email;
    private String phone;
    private String nation;
    private String hospital;
    private String department;    
    @Setter
    private String accessToken;
    
    public static AccountResponse toResponse(AccountEntity accountEntity, AccountInformationEntity accountInformationEntity) {
        return AccountResponse.builder()
        .passwordUpdatedDatetime(accountEntity.getPasswordUpdatedDatetime())
        .passwordNoticeDatetime(accountEntity.getPasswordNoticeDatetime())
        .createdDatetime(accountEntity.getCreatedDatetime())
        .lastLoginDatetime(accountEntity.getLastLoginDatetime())
        .loginCount(accountEntity.getLoginCount())
        .refreshToken(accountEntity.getRefreshToken())
        .status(accountEntity.getStatus())
        .terminationDatetime(accountEntity.getTerminationDatetime())
        .name(accountInformationEntity.getName())        
        .email(accountInformationEntity.getEmail())
        .phone(accountInformationEntity.getPhone())
        .nation(accountInformationEntity.getNation())
        .hospital(accountInformationEntity.getHospital())
        .department(accountInformationEntity.getDepartment())
        .build();
    }
}
