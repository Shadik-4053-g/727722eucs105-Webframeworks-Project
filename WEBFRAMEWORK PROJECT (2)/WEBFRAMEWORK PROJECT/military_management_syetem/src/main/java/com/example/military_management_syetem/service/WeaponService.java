package com.example.military_management_syetem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.military_management_syetem.model.Weapon;
import com.example.military_management_syetem.repository.WeaponRepository;


@Service
public class WeaponService {

    @Autowired
    private WeaponRepository weaponRepository;

    // Weapon operations
    public Weapon saveWeapon(Weapon weapon) {
        return weaponRepository.save(weapon);
    }

    public List<Weapon> getWeapons() {
        return weaponRepository.findAll();
    }

    public Weapon getWeapon(Long id) {
        return weaponRepository.findById(id).orElse(null);
    }

    public void deleteWeapon(Long id) {
        weaponRepository.deleteById(id);
    }

    public List<Weapon> getWeaponWeight(int a,int b){
        return weaponRepository.findbyweight(a,b);
    }

    // public List<Weapon> getPaginationforonetomany(int offset,int size)
    // {
    //     return weaponRepository.findAll(PageRequest.of(offset, size)).getContent();
                        
    // }
    
}
