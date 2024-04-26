package com.example.military_management_syetem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.military_management_syetem.model.Supply;

@Repository
public interface SupplyRepo extends JpaRepository<Supply, Integer> {
    
}
