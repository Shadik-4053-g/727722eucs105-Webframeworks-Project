package com.example.military_management_syetem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.military_management_syetem.model.Weapon;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {

    @Query( value = "SELECT a from Weapon a WHERE a.weight > ?1 AND a.weight < ?2")
    List<Weapon> findbyweight(int st,int ed);

    @Query( value = "SELECT * FROM  Weapon WHERE quantity > a", nativeQuery = true)
    List<Weapon> findbyquantity(@Param("val") int a);

    @Modifying
    @Query(value = "UPDATE Weapon a SET a.weapon_name = ?1 WHERE a.weapon_id = ?2")
    void updateWeapon(String a,int b);
    
}
