package com.fullcycle.eda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fullcycle.eda.repositories.entities.TransactionEvent;

import java.util.List;
import java.util.UUID;


public interface TransactionEventRepository extends JpaRepository<TransactionEvent, Long> {

    List<TransactionEvent> findByAccountIdOrderByEventTimeDesc(UUID accountId);

}
