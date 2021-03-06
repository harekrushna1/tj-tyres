package com.tjtyres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tjtyres.model.Fleet;

@Repository
public interface FleetRepository extends JpaRepository<Fleet, Long>{

}
