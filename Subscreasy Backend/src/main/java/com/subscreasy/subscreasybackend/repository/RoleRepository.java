package com.subscreasy.subscreasybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subscreasy.subscreasybackend.enums.RoleType;
import com.subscreasy.subscreasybackend.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	 Role findByName(RoleType name);
}