package com.example.military_management_syetem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.military_management_syetem.model.Supply;
import com.example.military_management_syetem.service.SupplyService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SupplyController {
    @Autowired
    private final SupplyService supplyService;

    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    // Supply operations
    @GetMapping("/supplies")
    public List<Supply> getSupplies() {
        return supplyService.findAll();
    }
    @GetMapping("/su")
    public Supply getSupplijhes() {
        return new Supply();
    }

    @GetMapping("/supply/{id}")
    public Supply getSupply(@PathVariable int id) {
        return supplyService.findById(id);
    }

    @PostMapping("/supply")
    public Supply saveSupply(@RequestBody Supply supply) {
        return supplyService.saveSupply(supply);
    }

    @PutMapping("/supply/{id}")
    public String updateSupply(@PathVariable int id, @RequestBody Supply updatedSupply) {
        Supply existingSupply = supplyService.findById(id);
        if (existingSupply != null) {
            existingSupply.setName(updatedSupply.getName());
            existingSupply.setDescription(updatedSupply.getDescription());
            existingSupply.setQuantity(updatedSupply.getQuantity());
            existingSupply.setExpirationDate(updatedSupply.getExpirationDate());
            existingSupply.setNutritionalInformation(updatedSupply.getNutritionalInformation());

            supplyService.updateSupply(existingSupply);

            return "Supply Updated";
        } else {
            return "No Data Found";
        }
    }

    @DeleteMapping("/supply/{id}")
    public String deleteSupply(@PathVariable int id) {
        Supply existingSupply = supplyService.findById(id);
        if (existingSupply != null) {
            supplyService.deleteSupply(id);
            return "Deleted";
        } else {
            return "No Data Found";
        }
    }
}
