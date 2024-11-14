package com.hypermedicus.rds.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hypermedicus.rds.entity.AccountClassificationEntity;

public interface AccountClassificationEntityRepository extends JpaRepository<AccountClassificationEntity, UUID>{
    Optional<AccountClassificationEntity> findByUuid(UUID uuid);
}
