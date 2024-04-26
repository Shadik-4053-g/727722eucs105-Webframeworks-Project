package com.example.military_management_syetem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.military_management_syetem.model.Weapon;
import com.example.military_management_syetem.service.WeaponService;

@RestController
@RequestMapping("/api")
public class WeaponController {

    @Autowired
    public WeaponService weaponService;
    
        // Weapon operations
        @GetMapping("/weapons")
        public List<Weapon> getWeapons() {
            return weaponService.getWeapons();
        }
    
        @GetMapping("/weapon/{id}")
        public Weapon getWeapon(@PathVariable Long id) {
            return weaponService.getWeapon(id);
        }
    
        @PostMapping("/weapon/post")
        public Weapon saveWeapon(@RequestBody Weapon weapon) {
            return weaponService.saveWeapon(weapon);
        }
    
        @PutMapping("/weapon/{id}")
        public String updateWeapon(@PathVariable Long id, @RequestBody Weapon updatedWeapon) {
            Weapon existingWeapon = weaponService.getWeapon(id);
            if (existingWeapon != null) {
                existingWeapon.setCaliber(updatedWeapon.getCaliber());
                existingWeapon.setManufacturer(updatedWeapon.getManufacturer());
                existingWeapon.setWeight(updatedWeapon.getWeight());
                existingWeapon.setQuantity(updatedWeapon.getQuantity());
        
                weaponService.saveWeapon(existingWeapon);
                
                return "Weapon Updated (excluding weapon name)";
            } else {
                return "No Data Found";
            }
        }
        
    
        @DeleteMapping("/weapon/{id}")
        public String deleteWeapon(@PathVariable Long id) {
            Weapon existingWeapon = weaponService.getWeapon(id);
            if (existingWeapon != null) {
                weaponService.deleteWeapon(id);
                return "Deleted";
            } else {
                return "No Data Found";
            }
        }


        @GetMapping("/example1")
        public String exampleWithRequestParam(@RequestParam("name") String name) {
            return "Hello, " + name + "!";
        }
    
        @GetMapping("/example2/{id}")
        public String exampleWithPathVariable(@PathVariable("id") Long id) {
            return "Received ID: " + id;
        }

        @GetMapping("/byweight/{a}/{b}")
        public List<Weapon> getMethodName(@PathVariable int a, @PathVariable int b) {
            return weaponService.getWeaponWeight(a,b);
        }

    //     @GetMapping("/pageonetomany/{offset}/{pagesize}")
    // public ResponseEntity<List<Weapon>> getMethodName1(@PathVariable("offset") int offset,@PathVariable("pagesize") int size) {
    //     List<Weapon> list = weaponService.getPaginationforonetomany(offset,size);
    //     if(list.size() == 0)
    //     {
    //         return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    //     }
    //     return new ResponseEntity<>(list,HttpStatus.OK);
    // }
}
