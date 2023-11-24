package com.EBRAIN.Staffes.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EBRAIN.Staffes.entity.Staffes;

@Repository
public interface StaffesRepositoroy extends JpaRepository<Staffes, UUID>{

	Optional<Staffes> findByName(String name);
}
