package com.hypermedicus.rds.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hypermedicus.rds.entity.AccountClassificationEntity;

public interface AccountClassificationRepository extends JpaRepository<AccountClassificationEntity, UUID>{
    
}
