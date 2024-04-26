package com.example.military_management_syetem.service;


import org.springframework.stereotype.Service;

import com.example.military_management_syetem.model.Supply;
import com.example.military_management_syetem.repository.SupplyRepo;

import java.util.List;

@Service
public class SupplyService {

    private final SupplyRepo supplyRepo;

    public SupplyService(SupplyRepo supplyRepo) {
        this.supplyRepo = supplyRepo;
    }

    public List<Supply> findAll() {
        return supplyRepo.findAll();
    }

    public Supply findById(int id) {
        return supplyRepo.findById(id).orElse(null);
    }

    public Supply saveSupply(Supply supply) {
        return supplyRepo.save(supply);
    }

    public Supply updateSupply(Supply supply) {
        return supplyRepo.save(supply);
    }

    public void deleteSupply(int id) {
        supplyRepo.deleteById(id);
    }
}
