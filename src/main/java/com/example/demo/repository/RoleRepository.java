package com.example.demo.repository;

import com.example.demo.entity.RoleEntity;
import com.example.demo.util.RoleUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>, JpaSpecificationExecutor<RoleEntity> {
    RoleEntity findByName(RoleUtil name);
}