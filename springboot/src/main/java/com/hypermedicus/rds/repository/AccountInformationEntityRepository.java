package com.hypermedicus.rds.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hypermedicus.rds.entity.AccountInformationEntity;

public interface AccountInformationEntityRepository extends JpaRepository<AccountInformationEntity, UUID>{
    Optional<AccountInformationEntity> findByUuid(UUID uuid);
}
