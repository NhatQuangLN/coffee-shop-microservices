package com.digital.service_product.logic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.common_lib.enums.MenuEnum.MenuStatus;
import com.digital.service_product.entity.MenuEntity;

@Repository
public interface IMenuRepository extends JpaRepository<MenuEntity, Long> {

	MenuEntity findByUuidAndStatus(String uuid, MenuStatus status);
}
