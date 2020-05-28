package com.tjtyres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tjtyres.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
