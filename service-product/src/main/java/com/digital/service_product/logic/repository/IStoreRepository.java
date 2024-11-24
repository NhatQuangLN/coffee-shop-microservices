package com.digital.service_product.logic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.service_product.entity.StoreEntity;

@Repository
public interface IStoreRepository extends JpaRepository<StoreEntity, Long> {

}
