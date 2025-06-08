package com.fullcycle.eda.repositories;

import com.fullcycle.eda.repositories.entities.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BalanceRepository extends JpaRepository<BalanceEntity, UUID> {
}