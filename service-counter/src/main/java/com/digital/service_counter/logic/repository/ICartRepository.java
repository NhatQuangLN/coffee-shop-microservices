package com.digital.service_counter.logic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.service_counter.entity.CartEntity;

@Repository
public interface ICartRepository extends JpaRepository<CartEntity, Long> {

	CartEntity findByUsernamAndStoreUuid(String username, String storeUuid);
}
